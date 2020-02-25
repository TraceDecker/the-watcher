# SQL data definition language (DDL)

```SQLite
CREATE TABLE IF NOT EXISTS `App`
(
    `app_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `app_name`    TEXT COLLATE NOCASE,
    `app_package` TEXT COLLATE NOCASE
);

CREATE INDEX IF NOT EXISTS `index_App_app_name` ON `App` (`app_name`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_App_app_package` ON `App` (`app_package`);

CREATE INDEX IF NOT EXISTS `index_Policy_time_value` ON `Policy` (`time_value`);

CREATE INDEX IF NOT EXISTS `index_Policy_app_id` ON `Policy` (`app_id`);

CREATE INDEX IF NOT EXISTS `index_Policy_location_id` ON `Policy` (`location_id`);

CREATE INDEX IF NOT EXISTS `index_Policy_restricted` ON `Policy` (`restricted`);

CREATE TABLE IF NOT EXISTS `Location`
(
    `location_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL COLLATE NOCASE,
    `location_name` TEXT COLLATE NOCASE,
    `longitude`     REAL                              NOT NULL,
    `latitude`      REAL                              NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Location_location_name` ON `Location` (`location_name`);

CREATE INDEX IF NOT EXISTS `index_Location_longitude` ON `Location` (`longitude`);

CREATE INDEX IF NOT EXISTS `index_Location_latitude` ON `Location` (`latitude`);

CREATE TABLE IF NOT EXISTS `Policy`
(
    `policy_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `app_id`      INTEGER                           NOT NULL,
    `location_id` INTEGER                           NOT NULL,
    `restricted`  INTEGER                           NOT NULL,
    `time_value`  INTEGER                           NOT NULL,
    FOREIGN KEY (`app_id`) REFERENCES `App` (`app_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`location_id`) REFERENCES `Location` (`location_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
```

[Download](ddl.sql)