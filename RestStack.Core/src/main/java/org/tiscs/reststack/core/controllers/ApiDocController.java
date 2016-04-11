package org.tiscs.reststack.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.tiscs.reststack.core.annotations.ApiDoc;
import org.tiscs.reststack.core.annotations.RequestQuery;
import org.tiscs.reststack.core.annotations.RequiresPermissions;
import org.tiscs.reststack.core.datamodels.ActionDoc;
import org.tiscs.reststack.core.datamodels.ParamDoc;
import org.tiscs.reststack.core.datamodels.ServiceDoc;
import org.tiscs.reststack.core.services.ApiDocService;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiDocController implements ApiDocService {
    @Autowired
    private ApplicationContext applicationContext;
    private Iterable<ServiceDoc> serviceDocs;

    @Override
    public Iterable<ServiceDoc> getServiceDocs() {
        if (serviceDocs == null) {
            List<ServiceDoc> result = new ArrayList<>();
            for (Object apiBean : applicationContext.getBeansWithAnnotation(RestController.class).values()) {
                if (apiBean instanceof ApiDocController) {
                    continue;
                }
                for (Class<?> clazz : apiBean.getClass().getInterfaces()) {
                    RequestMapping classMapping = clazz.isAnnotationPresent(RequestMapping.class) ? clazz.getAnnotation(RequestMapping.class) : null;
                    List<ActionDoc> actionDocs = new ArrayList<>();
                    for (Method method : clazz.getMethods()) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping methodMapping = method.getAnnotation(RequestMapping.class);
                            String path = classMapping != null && classMapping.value().length > 0 ? classMapping.value()[0] : "";
                            if (methodMapping.value().length > 0) {
                                path += methodMapping.value()[0];
                            }
                            path = path.replace("//", "/");
                            ActionDoc actionDoc = new ActionDoc();
                            actionDoc.setPath(path);
                            actionDoc.setMethod(methodMapping.method().length > 0 ? methodMapping.method()[0] : RequestMethod.GET);
                            actionDoc.setAction(method.getName());
                            if (method.isAnnotationPresent(ApiDoc.class)) {
                                ApiDoc methodApiDoc = method.getAnnotation(ApiDoc.class);
                                actionDoc.setName(methodApiDoc.name());
                                actionDoc.setDescription(methodApiDoc.description());
                                actionDoc.setOwner(methodApiDoc.owner());
                            }
                            if (method.isAnnotationPresent(RequiresPermissions.class)) {
                                RequiresPermissions methodPermissions = method.getAnnotation(RequiresPermissions.class);
                                actionDoc.setPermissions(methodPermissions.value());
                            }
                            actionDoc.setResult(method.getReturnType().getName());
                            List<ParamDoc> pathParamDocs = new ArrayList<>();
                            List<ParamDoc> queryParamDocs = new ArrayList<>();
                            for (Parameter parameter : method.getParameters()) {
                                ParamDoc paramDoc = new ParamDoc();
                                paramDoc.setParamName(parameter.getName());
                                paramDoc.setParamType(parameter.getType().getName());
                                for (int i = 0; i < parameter.getType().getTypeParameters().length; i++) {
                                    if (i == 0) {
                                        paramDoc.setParamType(paramDoc.getParamType() + "<");
                                    }
                                    if (i > 0 && i < parameter.getType().getTypeParameters().length - 1) {
                                        paramDoc.setParamType(paramDoc.getParamType() + ", ");
                                    }
                                    paramDoc.setParamType(paramDoc.getParamType() + parameter.getType().getTypeParameters()[i].getName());
                                    if (i == parameter.getType().getTypeParameters().length - 1) {
                                        paramDoc.setParamType(paramDoc.getParamType() + ">");
                                    }
                                }
                                if (parameter.isAnnotationPresent(ApiDoc.class)) {
                                    ApiDoc parameterApiDoc = parameter.getAnnotation(ApiDoc.class);
                                    paramDoc.setName(parameterApiDoc.name());
                                    paramDoc.setDescription(parameterApiDoc.description());
                                }
                                if (parameter.isAnnotationPresent(PathVariable.class)) {
                                    paramDoc.setRequired(true);
                                    pathParamDocs.add(paramDoc);
                                } else if (parameter.isAnnotationPresent(RequestParam.class)) {
                                    paramDoc.setRequired(parameter.getAnnotation(RequestParam.class).required());
                                    queryParamDocs.add(paramDoc);
                                } else if (parameter.isAnnotationPresent(RequestBody.class)) {
                                    paramDoc.setRequired(parameter.getAnnotation(RequestBody.class).required());
                                    actionDoc.setBodyParam(paramDoc);
                                } else if (parameter.isAnnotationPresent(RequestQuery.class)) {
                                    queryParamDocs.add(paramDoc);
                                }
                            }
                            actionDoc.setPathParams(pathParamDocs);
                            actionDoc.setQueryParams(queryParamDocs);
                            actionDocs.add(actionDoc);
                        }
                    }
                    if (actionDocs.size() > 0) {
                        ServiceDoc serviceDoc = new ServiceDoc();
                        serviceDoc.setController(clazz.getName());
                        if (clazz.isAnnotationPresent(ApiDoc.class)) {
                            ApiDoc serviceApiDoc = clazz.getAnnotation(ApiDoc.class);
                            serviceDoc.setName(serviceApiDoc.name());
                            serviceDoc.setDescription(serviceApiDoc.description());
                        }
                        serviceDoc.setActions(actionDocs);
                        result.add(serviceDoc);
                    }
                }
            }
            serviceDocs = result;
        }
        return serviceDocs;
    }
}
