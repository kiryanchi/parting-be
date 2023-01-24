INSERT INTO categories (category_id,category_name,created_at,updated_at,status) VALUES
                                                                                    (1,'문화생활팟','2022-01-06','2022-01-06','active'),
                                                                                    (2,'관람팟','2022-01-06','2022-01-06','active'),
                                                                                    (3,'자기개발팟','2022-01-06','2022-01-06','active'),
                                                                                    (4,'한입팟','2022-01-06','2022-01-06','active'),
                                                                                    (5,'운동팟','2022-01-06','2022-01-06','active'),
                                                                                    (6,'오락팟','2022-01-06','2022-01-06','active'),
                                                                                    (7,'카페팟','2022-01-06','2022-01-06','active'),
                                                                                    (8,'한잔팟','2022-01-06','2022-01-06','active');

INSERT INTO categories_detail (category_detail_id,category_name,created_at,updated_at,status,category_id) VALUES
                                                                                                              (1,'test1','2022-01-06','2022-01-06','active',1),
                                                                                                              (2,'test2','2022-01-06','2022-01-06','active',1),
                                                                                                              (3,'test3','2022-01-06','2022-01-06','active',2),
                                                                                                              (4,'test4','2022-01-06','2022-01-06','active',2),
                                                                                                              (5,'test5','2022-01-06','2022-01-06','active',3),
                                                                                                              (6,'test6','2022-01-06','2022-01-06','active',3),
                                                                                                              (7,'test7','2022-01-06','2022-01-06','active',4),
                                                                                                              (8,'test8','2022-01-06','2022-01-06','active',4),
                                                                                                              (9,'test8','2022-01-06','2022-01-06','active',5),
                                                                                                              (10,'test8','2022-01-06','2022-01-06','active',5),
                                                                                                              (11,'test8','2022-01-06','2022-01-06','active',6),
                                                                                                              (12,'test8','2022-01-06','2022-01-06','active',6),
                                                                                                              (13,'test8','2022-01-06','2022-01-06','active',7),
                                                                                                              (14,'test8','2022-01-06','2022-01-06','active',7),
                                                                                                              (15,'test8','2022-01-06','2022-01-06','active',8),
                                                                                                              (16,'test8','2022-01-06','2022-01-06','active',8);

INSERT INTO interests (interrest_id,interest_name,status) VALUES
                                                              (1,'문화생활팟','active'),
                                                              (2,'관람팟','active'),
                                                              (3,'자기개발팟','active'),
                                                              (4,'한입팟','active'),
                                                              (5,'운동팟','active'),
                                                              (6,'오락팟','active'),
                                                              (7,'카페팟','active'),
                                                              (8,'한잔팟','active');

INSERT INTO interest_details(interest_detail_id,interest_name,status,intereset_id) VALUES
                                                                                       (1,'test1','active',1),
                                                                                       (2,'test2','active',1),
                                                                                       (3,'test3','active',2),
                                                                                       (4,'test4','active',2),
                                                                                       (5,'test5','active',3),
                                                                                       (6,'test6','active',3),
                                                                                       (7,'test7','active',4),
                                                                                       (8,'test8','active',4),
                                                                                       (9,'test8','active',5),
                                                                                       (10,'test8','active',5),
                                                                                       (11,'test8','active',6),
                                                                                       (12,'test8','active',6),
                                                                                       (13,'test8','active',7),
                                                                                       (14,'test8','active',7),
                                                                                       (15,'test8','active',8),
                                                                                       (16,'test8','active',8);


INSERT INTO parties(id,capacity,comment,dead_line,issecret,max_age,min_age,party_name,party_start_date_time,party_end_date_time,store_img_url,store_name,utmx,utmy,category_detail_id,created_at,updated_at,status) VALUES
                                                                                                                                                                                                                        (1,5,'오세요','2022-01-08 17:00','Y',25,20,'술팟','2023-01-23 12:00:00','2023-01-23 12:00:00','https://imgurl','술집',20,30,1,'2023-01-07','2023-01-07','active'),
                                                                                                                                                                                                                        (2,3,'오세요2','2022-01-08 17:00','Y',25,20,'술팟2','2023-01-07 00:00:00','2023-01-23 12:00:00','https://imgurl','술집',20,30,1,'2023-01-07','2023-01-07','inactive'),
                                                                                                                                                                                                                        (3,3,'오세요3','2022-01-08 17:00','Y',25,20,'술팟2','2023-01-07 00:00:00','2023-01-23 12:00:00','https://imgurl','술집',20,30,1,'2023-01-07','2023-01-07','active');

INSERT INTO hashtags (hashtag_id,hashtag_name,party_id,created_at,status) VALUES
                                                                              (1,'인싸들 다 모여라~!',1,'2023-01-08','active'),
                                                                              (2,'인싸들 다 모여라~!2',1,'2023-01-08','active'),
                                                                              (3,'인싸들 다 모여라~!3',1,'2023-01-08','active');

INSERT INTO USERS (id,birth,nick_name,profile_img_url,reliability,sex,tel) VALUES
                                                                               (1,'1999-01-02','ayaan','https://imgUrl',100,'M','010-8505-0877'),
                                                                               (2,'1999-01-02','Ayaan','https://imgUrl',100,'M','010-8505-0877'),
                                                                               (3,'1999-01-02','민욱','https://imgUrl',100,'W','010-8505-0877');

insert into user_interest_mapping (id,interest_id,user_id,created_at,updated_at,status) values
                                                                                            (1,1,1,'2022-01-01','2022-01-01','active'),
                                                                                            (2,2,1,'2022-01-01','2022-01-01','active'),
                                                                                            (3,3,2,'2022-01-01','2022-01-01','active'),
                                                                                            (4,4,2,'2022-01-01','2022-01-01','active'),
                                                                                            (5,5,3,'2022-01-01','2022-01-01','active'),
                                                                                            (6,6,3,'2022-01-01','2022-01-01','active'),
                                                                                            (7,7,1,'2022-01-01','2022-01-01','active');
insert into user_party_mapping (id,party_id,user_id,status) VALUES
                                                                (1,1,1,'host'),
                                                                (2,1,2,'normal_member'),
                                                                (3,1,3,'normal_member'),
                                                                (4,2,1,'host'),
                                                                (5,2,2,'normal_member'),
                                                                (6,2,3,'normal_member'),
                                                                (7,3,1,'host'),
                                                                (8,3,3,'normal_member');