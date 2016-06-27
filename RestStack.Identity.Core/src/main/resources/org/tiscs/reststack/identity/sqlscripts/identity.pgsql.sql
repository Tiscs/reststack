-- ----------------------------
-- Table of Entity "User"
-- ----------------------------
DROP TABLE IF EXISTS "identity"."users";

CREATE TABLE "identity"."users" (
  "id" uuid NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "last_modified" timestamp(6),
  "deleted" bool NOT NULL,
  "activated" bool NOT NULL,
  "name" varchar(128) COLLATE "default" NOT NULL,
  "gender" varchar(128) COLLATE "default" NOT NULL,
  "email" varchar(64) COLLATE "default" NOT NULL,
  "email_verified" bool NOT NULL,
  "phone_number" varchar(64) COLLATE "default" NOT NULL,
  "phone_number_verified" bool NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE "identity"."users" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Table of Entity "Role"
-- ----------------------------
DROP TABLE IF EXISTS "identity"."roles";

CREATE TABLE "identity"."roles" (
  "id" uuid NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "last_modified" timestamp(6),
  "disabled" bool NOT NULL,
  "name" varchar(128) COLLATE "default" NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE "identity"."roles" ADD PRIMARY KEY ("id");