insert into course(type,  main_description, sub_description, image_url, line_image_url,background_image_url, main_image_url,level, estimated_time, price,background_gif_url) values (0, '연인과 소중한 추억을 남기기 좋은 코스입니다.', '연인끼리 추억 남기기 좋은 핫스팟', 'https://dmzing-s3.s3.ap-northeast-2.amazonaws.com/review/1542385562535_review_date_img%402x.png', 'www.image.example.com1','www.image.example.com1','https://dmzing-s3.s3.ap-northeast-2.amazonaws.com/review/1542549670887_home_date_img%402x.png', 0, 3, 0,'www.image.example.com1');
insert into course(type,  main_description, sub_description, image_url, line_image_url,background_image_url, main_image_url,level, estimated_time, price,background_gif_url) values (1, 'DMZ 역사기행코스를 통해 우리의 역사를 공부할 수 있는 코스입니다.', '우리의 역사를 알 수 있는 명소들', 'https://dmzing-s3.s3.ap-northeast-2.amazonaws.com/review/1542385611095_review_explore_img%402x.png', 'www.image.example.com1','www.image.example.com1','https://dmzing-s3.s3.ap-northeast-2.amazonaws.com/review/1542549691923_home_history_img%402x.png', 1, 4, 400,'www.image.example.com1');
insert into course(type,  main_description, sub_description, image_url, line_image_url,background_image_url,main_image_url,level, estimated_time, price,background_gif_url) values (2, '지친 일상을 힐링해 줄 자연탐방 코스입니다.', '자연 속 힐링할 수 있는 장소', 'https://dmzing-s3.s3.ap-northeast-2.amazonaws.com/review/1542549528050_review_nature_img%402x.png', 'www.image.example.com1','www.image.example.com1','https://dmzing-s3.s3.ap-northeast-2.amazonaws.com/review/1542549712047_home_nature_img%402x.png', 2, 3.5, 550,'www.image.example.com1');

insert into user(id, authority, dmz_point, email, nickname, password, phone_number) values (1,'USER' ,500, 'example@gmail.com', '최유성', '$2a$10$oXEj64jIfbb/2MR/k9JYp.ejMGknQ9VMkZeoIVhQda6QAK9sgUOYO', '010-0000-0000');

-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (1, 1, '힌트1', 111, 111,  '편지url1', '장소1', '100', 1, 111, 11);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (2, 1, '힌트2', 222, 222,  '편지url2', '장소2', '100', 2, 222, 22);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (3, 1, '힌트3', 333, 333,  '편지url3', '장소3', '100', 3, 333, 33);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (4, 1, '힌트4', 444, 444,  '편지url4', '장소4', '100', 4, 444, 44);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (5, 1, '힌트5', 555, 555,  '편지url5', '장소5', '100', 5, 555, 55);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (6, 2, '힌트6', 666, 666,  '편지url6', '장소6', '100', 1, 666, 66);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (7, 2, '힌트7', 777, 777,  '편지url7', '장소7', '100', 2, 777, 77);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (8, 2, '힌트8', 888, 888,  '편지url8', '장소8', '100', 3, 888, 88);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (9, 2, '힌트9', 999, 999,  '편지url9', '장소9', '100', 4, 999, 99);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (10, 3, '힌트10', 1010, 1010,  '편지url10', '장소10', '100', 1, 1010, 1010);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (11, 3, '힌트11', 1111, 1111,  '편지url11', '장소11', '100', 2, 1111, 1111);
-- insert into place(id, course_id, hint, latitude, longitude,  letter_image_url, title, reward, sequence, tour_type_id, content_id) values (12, 3, '힌트12', 1212, 1212,  '편지url12', '장소12', '100', 3, 1212, 1212);
INSERT INTO purchased_course_by_user(is_picked,course_id,user_id) VALUES(true, 1, 1);
INSERT INTO purchased_course_by_user(is_picked,course_id,user_id) VALUES(false, 2, 1);
-- insert into MISSION_HISTORY(place_id,PURCHASED_COURSES_BY_USER_id) values (1,1);
-- insert into MISSION_HISTORY(place_id,PURCHASED_COURSES_BY_USER_id) values (2,1);
