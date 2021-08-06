use my_learn;

show tables;

select * from student where id = 5 and name like '田%';


CREATE TABLE `app_user` (
                            `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(50) DEFAULT '',
                            `email` VARCHAR(50) NOT NULL,
                            `phone` VARCHAR(20) DEFAULT '',
                            `gender` TINYINT(4) UNSIGNED DEFAULT '0',
                            `password` VARCHAR(100) NOT NULL DEFAULT '',
                            `age` TINYINT(4) DEFAULT NULL,
                            `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
                            `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
set global log_bin_trust_function_creators=TRUE;
-- 插入100万数据
DELIMITER $$ --  写函数之前必写
CREATE FUNCTION mock_data()
    RETURNS INT
BEGIN
    DECLARE num INT DEFAULT 1000000;
    DECLARE i INT DEFAULT 0;

    WHILE i<num DO
            -- 插入语句
            INSERT INTO app_user(`name`,`email`,`phone`,`gender`,`password`,`age`)
                VALUE(CONCAT('用户',i),'534240118@qq.com',FLOOR (CONCAT('18',RAND()*9999999)),FLOOR (RAND()*2),
                      UUID(),FLOOR (RAND()*100));

            SET i = i+1;
        END WHILE;
    RETURN i;


END;
select * from app_user;
SELECT mock_data();

SELECT * FROM app_user WHERE `name`='用户9999'; -- 接近半秒

EXPLAIN SELECT * FROM app_user WHERE `name`='用户9999';  -- 查询99999条记录

-- id _ 表名_字段名
-- create index on 字段
CREATE INDEX id_app_user_name ON app_user(`name`); -- 0.001 s
EXPLAIN SELECT * FROM app_user WHERE `name`='用户9999';  -- 查询一条记录

show index from app_user;
select * from app_user where gender = 4;
update app_user set gender = 4 where id = 999999;
alter table app_user add index name(name);
drop index id_app_user_name on app_user;
SELECT * FROM app_user WHERE `name`='用户999999';#1s252ms
create index name on app_user("name");
CREATE INDEX id_app_user_name ON app_user(`name`);#8s256ms
select count(name) from app_user;
SELECT * FROM app_user WHERE `name`='用户999999';#94ms 提高查询速度啊!
select * from app_user where gender = 4; #1s609ms
create index CREAT_TIME on app_user(create_time);
explain select * from app_user where create_time = 1667;
alter table app_user add index GENDER(gender);
show index from app_user;
select * from app_user where gender = 4; ##55ms

desc app_user;
show create table app_user;
show index from app_user;
select * from app_user;
explain select a.id,a.gender,a.name from app_user a;
explain select a.age,a.phone from app_user a ;


#创建组合索引
create index id_name_age on app_user(id,name(10),age);
update app_user set name = 'smart'where id = 999999;
explain select * from app_user where id = 999999 and age = 22 and name = 'smart';
show index from app_user;
drop index GENDER on app_user;
explain select * from app_user where id = 999999;
explain select * from app_user where gender = 4;
create index gender on app_user(gender);
explain select id from app_user;
desc app_user;

explain select gender from app_user left join user u on u.password = app_user.password;
show index from user;

#create index USERNAME,PASSWORD on user(username,password);

show full columns from app_user;
show full columns from user;

ALTER TABLE user CHANGE out_trade_no out_trade_no VARCHAR(32)
    CHARACTER SET utf8mb4 COLLATE utf8_general_ci;

show variables like 'character%';

#加索引提高查修时间啊！
explain select * from app_user where create_time = 20210805;

select * from app_user where update_time = 20210806110440;