# SQL data definition language (DDL)

```SQLite
CREATE TABLE IF NOT EXISTS `${TABLE_NAME}`
(
    `app_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `app_name`    TEXT COLLATE NOCASE,
    `app_package` TEXT COLLATE NOCASE
);
CREATE INDEX IF NOT EXISTS `index_AppEntity_app_name` ON `${TABLE_NAME}` (`app_name`);
CREATE UNIQUE INDEX IF NOT EXISTS `index_AppEntity_app_package` ON `${TABLE_NAME}` (`app_package`);
CREATE TABLE IF NOT EXISTS `${TABLE_NAME}`
(
    `policy_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `app_id`      INTEGER                           NOT NULL,
    `location_id` INTEGER                           NOT NULL,
    `restricted`  INTEGER                           NOT NULL,
    `time_value`  INTEGER                           NOT NULL,
    FOREIGN KEY (`app_id`) REFERENCES `${TABLE_NAME}` (`app_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`location_id`) REFERENCES `${TABLE_NAME}` (`location_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE INDEX IF NOT EXISTS `index_PolicyEntity_time_value` ON `${TABLE_NAME}` (`time_value`);
CREATE INDEX IF NOT EXISTS `index_PolicyEntity_app_id` ON `${TABLE_NAME}` (`app_id`);
CREATE INDEX IF NOT EXISTS `index_PolicyEntity_location_id` ON `${TABLE_NAME}` (`location_id`);
CREATE INDEX IF NOT EXISTS `index_PolicyEntity_restricted` ON `${TABLE_NAME}` (`restricted`);
CREATE TABLE IF NOT EXISTS `${TABLE_NAME}`
(
    `location_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL COLLATE NOCASE,
    `location_name` TEXT COLLATE NOCASE,
    `longitude`     REAL                              NOT NULL,
    `latitude`      REAL                              NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_LocationEntity_location_name` ON `${TABLE_NAME}` (`location_name`);
CREATE INDEX IF NOT EXISTS `index_LocationEntity_longitude` ON `${TABLE_NAME}` (`longitude`);
CREATE INDEX IF NOT EXISTS `index_LocationEntity_latitude` ON `${TABLE_NAME}` (`latitude`);


```

[Download](ddl.sql)