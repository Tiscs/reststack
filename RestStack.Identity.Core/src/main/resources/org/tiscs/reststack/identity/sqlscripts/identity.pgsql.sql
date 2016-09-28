-- ----------------------------
--  Table structure for oauth2_agents
-- ----------------------------
DROP TABLE IF EXISTS "identity"."oauth2_agents";
CREATE TABLE "identity"."oauth2_agents" (
  "client_id" uuid NOT NULL,
  "user_id" uuid NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "expires_in" int8 NOT NULL,
  "scope" varchar(32) NOT NULL COLLATE "default",
  "access_token" varchar(32) NOT NULL COLLATE "default",
  "refresh_token" varchar(32) NOT NULL COLLATE "default",
  "last_modified" timestamp(6) NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "identity"."oauth2_agents" OWNER TO "postgres";

-- ----------------------------
--  Table structure for oauth2_clients
-- ----------------------------
DROP TABLE IF EXISTS "identity"."oauth2_clients";
CREATE TABLE "identity"."oauth2_clients" (
  "id" uuid NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "last_modified" timestamp(6) NULL,
  "disabled" bool NOT NULL,
  "name" varchar(128) NOT NULL COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "identity"."oauth2_clients" OWNER TO "postgres";

-- ----------------------------
--  Table structure for oauth2_requests
-- ----------------------------
DROP TABLE IF EXISTS "identity"."oauth2_requests";
CREATE TABLE "identity"."oauth2_requests" (
  "client_id" uuid NOT NULL,
  "user_id" uuid NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "expires_in" int8 NOT NULL,
  "redirect_uri" varchar(2048) COLLATE "default",
  "scope" varchar(32) NOT NULL COLLATE "default",
  "code" varchar(32) NOT NULL COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "identity"."oauth2_requests" OWNER TO "postgres";

-- ----------------------------
--  Table structure for role_permissions
-- ----------------------------
DROP TABLE IF EXISTS "identity"."role_permissions";
CREATE TABLE "identity"."role_permissions" (
  "role_id" uuid NOT NULL,
  "permission_key" varchar(256) NOT NULL COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "identity"."role_permissions" OWNER TO "postgres";

-- ----------------------------
--  Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS "identity"."roles";
CREATE TABLE "identity"."roles" (
  "id" uuid NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "last_modified" timestamp(6) NULL,
  "disabled" bool NOT NULL,
  "name" varchar(128) NOT NULL COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "identity"."roles" OWNER TO "postgres";

-- ----------------------------
--  Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS "identity"."user_roles";
CREATE TABLE "identity"."user_roles" (
  "user_id" uuid NOT NULL,
  "role_id" uuid NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "identity"."user_roles" OWNER TO "postgres";

-- ----------------------------
--  Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "identity"."users";
CREATE TABLE "identity"."users" (
  "id" uuid NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "last_modified" timestamp(6) NULL,
  "deleted" bool NOT NULL,
  "activated" bool NOT NULL,
  "name" varchar(128) NOT NULL COLLATE "default",
  "gender" varchar(128) NOT NULL COLLATE "default",
  "email" varchar(64) NOT NULL COLLATE "default",
  "email_verified" bool NOT NULL,
  "phone_number" varchar(64) NOT NULL COLLATE "default",
  "phone_number_verified" bool NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "identity"."users" OWNER TO "postgres";

-- ----------------------------
--  Primary key structure for table oauth2_agents
-- ----------------------------
ALTER TABLE "identity"."oauth2_agents" ADD PRIMARY KEY ("client_id", "user_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table oauth2_agents
-- ----------------------------
ALTER TABLE "identity"."oauth2_agents" ADD CONSTRAINT "oauth2_agents_access_token" UNIQUE ("access_token") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "identity"."oauth2_agents" ADD CONSTRAINT "oauth2_agents_refresh_token" UNIQUE ("refresh_token") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table oauth2_clients
-- ----------------------------
ALTER TABLE "identity"."oauth2_clients" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table oauth2_clients
-- ----------------------------
ALTER TABLE "identity"."oauth2_clients" ADD CONSTRAINT "oauth2_clients_name" UNIQUE ("name") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table oauth2_clients
-- ----------------------------
CREATE UNIQUE INDEX  "oauth2_clients_id_key" ON "identity"."oauth2_clients" USING btree("id" "pg_catalog"."uuid_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table oauth2_requests
-- ----------------------------
ALTER TABLE "identity"."oauth2_requests" ADD PRIMARY KEY ("client_id", "user_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table oauth2_requests
-- ----------------------------
ALTER TABLE "identity"."oauth2_requests" ADD CONSTRAINT "oauth2_requests_code" UNIQUE ("code") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table role_permissions
-- ----------------------------
ALTER TABLE "identity"."role_permissions" ADD PRIMARY KEY ("role_id", "permission_key") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table roles
-- ----------------------------
ALTER TABLE "identity"."roles" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table roles
-- ----------------------------
CREATE UNIQUE INDEX  "roles_id_key" ON "identity"."roles" USING btree("id" "pg_catalog"."uuid_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table user_roles
-- ----------------------------
ALTER TABLE "identity"."user_roles" ADD PRIMARY KEY ("user_id", "role_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table users
-- ----------------------------
ALTER TABLE "identity"."users" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table users
-- ----------------------------
CREATE UNIQUE INDEX  "users_id_key" ON "identity"."users" USING btree("id" "pg_catalog"."uuid_ops" ASC NULLS LAST);
CREATE UNIQUE INDEX  "users_name" ON "identity"."users" USING btree("name" COLLATE "default" "pg_catalog"."text_ops" ASC NULLS LAST);

-- ----------------------------
--  Foreign keys structure for table oauth2_agents
-- ----------------------------
ALTER TABLE "identity"."oauth2_agents" ADD CONSTRAINT "oauth2_agents_client_id_oauth2_clients_id" FOREIGN KEY ("client_id") REFERENCES "identity"."oauth2_clients" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "identity"."oauth2_agents" ADD CONSTRAINT "oauth2_agents_user_id_users_id" FOREIGN KEY ("user_id") REFERENCES "identity"."users" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table oauth2_requests
-- ----------------------------
ALTER TABLE "identity"."oauth2_requests" ADD CONSTRAINT "oauth2_requests_client_id_oauth2_clients_id" FOREIGN KEY ("client_id") REFERENCES "identity"."oauth2_clients" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "identity"."oauth2_requests" ADD CONSTRAINT "oauth2_requests_user_id_users_id" FOREIGN KEY ("user_id") REFERENCES "identity"."users" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table role_permissions
-- ----------------------------
ALTER TABLE "identity"."role_permissions" ADD CONSTRAINT "role_permissions_role_id_roles_id" FOREIGN KEY ("role_id") REFERENCES "identity"."roles" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table user_roles
-- ----------------------------
ALTER TABLE "identity"."user_roles" ADD CONSTRAINT "user_roles_user_id_users_id" FOREIGN KEY ("user_id") REFERENCES "identity"."users" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "identity"."user_roles" ADD CONSTRAINT "user_roles_role_id_roles_id" FOREIGN KEY ("role_id") REFERENCES "identity"."roles" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

