DROP TABLE IF EXISTS resource_dir;
DROP TABLE IF EXISTS resource_file_item;
DROP TABLE IF EXISTS file_item_thumbnail;

CREATE TABLE resource_dir (
    id INT NOT NULL primary key,
    dir_name varchar(512),
    dir_path varchar(512)
);

CREATE TABLE resource_file_item (
    id INT NOT NULL primary key,
    resource_dir_id INT NOT NULL,
    item_file_md5 varchar(512),
    item_filename varchar(512),
    item_file_path varchar(512),
    item_file_size INT,
    item_file_type varchar(32)
);

CREATE TABLE file_item_thumbnail (
    id INT NOT NULL primary key,
    resource_file_item_id INT NOT NULL,
    item_thumbnail_file_path varchar(512)
)