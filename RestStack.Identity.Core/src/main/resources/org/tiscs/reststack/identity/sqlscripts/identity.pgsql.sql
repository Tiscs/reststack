-- ----------------------------
-- Table of Entity "User"
-- ----------------------------
DROP TABLE IF EXISTS "identity"."Users";

CREATE TABLE "identity"."Users" (
  "id" uuid NOT NULL,
  "createTime" timestamp(6) NOT NULL,
  "lastModified" timestamp(6),
  "deleted" bool NOT NULL,
  "activated" bool NOT NULL,
  "name" varchar(128) COLLATE "default" NOT NULL,
  "gender" varchar(128) COLLATE "default" NOT NULL,
  "phoneNumber" varchar(64) COLLATE "default" NOT NULL,
  "phoneNumberVerified" bool NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE "identity"."Users" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Table of Entity "Role"
-- ----------------------------
DROP TABLE IF EXISTS "identity"."Roles";

CREATE TABLE "identity"."Roles" (
  "id" uuid NOT NULL,
  "createTime" timestamp(6) NOT NULL,
  "lastModified" timestamp(6),
  "disabled" bool NOT NULL,
  "name" varchar(128) COLLATE "default" NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE "identity"."Roles" ADD PRIMARY KEY ("id");