

CREATE TABLE pictures(
	id INT PRIMARY KEY AUTO_INCREMENT,
    path VARCHAR(255) NOT NULL,
	size DECIMAL(10,2) NOT NULL
);

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL,
    profile_picture_id INT,
    
    CONSTRAINT fk_users_pictures
    FOREIGN KEY(profile_picture_id)
    REFERENCES pictures(id)
);

CREATE TABLE posts(
	id INT PRIMARY KEY	AUTO_INCREMENT,
    caption VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    picture_id INT NOT NULL,
    
    CONSTRAINT fk_posts_users
    FOREIGN KEY(user_id)
    REFERENCES users(id),
    
    CONSTRAINT fk_posts_pictures
    FOREIGN KEY(picture_id)
    REFERENCES pictures(id)
);

CREATE TABLE comments(
	id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    
    CONSTRAINT fk_comments_users
    FOREIGN KEY(user_id)
    REFERENCES users(id),
    
    CONSTRAINT fk_comments_posts
    FOREIGN KEY(post_id)
    REFERENCES posts(id)
);

CREATE TABLE users_followers(
	user_id INT,
    follower_id INT,
    
    CONSTRAINT fk_users_followers_users
    FOREIGN KEY(user_id)
    REFERENCES users(id),
    
    CONSTRAINT fk_users_followers_followers
    FOREIGN KEY(follower_id)
    REFERENCES users(id)
);

INSERT INTO pictures (id, path, size)
VALUES
(1, 'src/folders/resources/images/profile/blocked/bmp/kjOJjKpKh4.bmp', 32495.57),
(2, 'src/folders/resources/images/post/timeline/png/27kLXVm22Q.png', 44273.27),
(3, 'src/folders/resources/images/profile/browsed/bmp/Q52q15Zefa.bmp', 12444.36),
(4, 'src/folders/resources/images/uploads/blocked/png/45Q92hqN5V.png', 51087.72),
(5, 'src/folders/resources/images/story/infigured/bmp/kBigUt6GJf.bmp', 6638.98),
(6, 'src/folders/resources/images/post/browsed/bmp/QBN576hx4u.bmp', 10673.45),
(7, 'src/folders/resources/images/mobile/blocked/digi/3ISlOl969f.digi', 33820.37),
(8, 'src/folders/resources/images/profile/blocked/jpg/pgfMG75k4e.jpg', 41669.90),
(9, 'src/folders/resources/images/post/infigured/jpeg/F665808Atc.jpeg', 239.69),
(10, 'src/folders/resources/images/post/blocked/img/DTy126lX2w.img', 31013.45),
(11, 'src/folders/resources/images/uploads/refined/jpeg/Dl5coYebcH.jpeg', 5826.43),
(12, 'src/folders/resources/images/story/browsed/png/ubMYHgzhYb.png', 35756.39),
(13, 'src/folders/resources/images/profile/reformatted/img/W0ks4a39fb.img', 13893.83),
(14, 'src/folders/resources/images/profile/blocked/jpeg/fB3x0NwaNY.jpeg', 12210.73),
(15, 'src/folders/resources/images/post/reformatted/jpeg/e72c83y974.jpeg', 6117.43),
(16, 'src/folders/resources/images/story/blocked/jpeg/6Zjri62vV7.jpeg', 59271.39),
(17, 'src/folders/resources/images/post/infigured/vga/73VdtF2MRV.vga', 364.47),
(18, 'src/folders/resources/images/post/infigured/digi/32L06LKKKG.digi', 20341.74),
(19, 'src/folders/resources/images/post/infigured/png/17c7oNj50V.png', 1581.75),
(20, 'src/folders/resources/images/story/browsed/jpg/p27t303Lra.jpg', 60160.73),
(21, 'src/folders/resources/images/profile/timeline/img/G77y9DQuv0.img', 45078.92),
(22, 'src/folders/resources/images/uploads/blocked/jpg/QBBXQT8K9D.jpg', 3616.76),
(23, 'src/folders/resources/images/profile/browsed/png/8c4B83uw03.png', 2479.23),
(24, 'src/folders/resources/images/mobile/infigured/digi/YV2Lj6g0t4.digi', 292.96),
(25, 'src/folders/resources/images/profile/infigured/png/064mWZ2NaQ.png', 9454.87),
(26, 'src/folders/resources/images/mobile/blocked/jpg/YzCzZ5qk3P.jpg', 2129.41),
(27, 'src/folders/resources/images/post/infigured/vga/2vt1VWUuq3.vga', 13553.99),
(28, 'src/folders/resources/images/story/infigured/png/9H9M5a59Li.png', 34568.62),
(29, 'src/folders/resources/images/uploads/formed/png/719fXvccM9.png', 62300.48),
(30, 'src/folders/resources/images/profile/browsed/jpg/SFlUF20Ypm.jpg', 10158.76),
(31, 'src/folders/resources/images/story/blocked/png/1S2el3wJ3v.png', 10960.40),
(32, 'src/folders/resources/images/post/formed/vga/fO9Sp94k4K.vga', 52531.42),
(33, 'src/folders/resources/images/uploads/timeline/jpeg/2BZvc3RXA2.jpeg', 39184.46),
(34, 'src/folders/resources/images/mobile/blocked/jpg/reCEAwPN3Z.jpg', 2475.45),
(35, 'src/folders/resources/images/uploads/browsed/bmp/8AePN8J51t.bmp', 2433.36),
(36, 'src/folders/resources/images/post/formed/digi/6YLvj97k03.digi', 35037.91),
(37, 'src/folders/resources/images/profile/refined/jpg/g3BWLTG39t.jpg', 56284.92),
(38, 'src/folders/resources/images/story/reformatted/jpg/y3tGM8E88H.jpg', 41064.03),
(39, 'src/folders/resources/images/uploads/browsed/vga/n5xg70JZDw.vga', 30761.07),
(40, 'src/folders/resources/images/uploads/formed/vga/E5c2G5rHLF.vga', 45674.39),
(41, 'src/folders/resources/images/post/formed/jpg/5eEjkxhYd3.jpg', 33587.94),
(42, 'src/folders/resources/images/post/timeline/digi/cM8i5E0597.digi', 29979.08),
(43, 'src/folders/resources/images/profile/reformatted/png/4Hg7J3qBNc.png', 52470.04),
(44, 'src/folders/resources/images/profile/browsed/png/841p0J24Oa.png', 73543.36),
(45, 'src/folders/resources/images/story/reformatted/img/hRI3TW31rC.img', 39559.96),
(46, 'src/folders/resources/images/story/refined/digi/CZVLmmtd5Y.digi', 7084.08),
(47, 'src/folders/resources/images/story/infigured/vga/Rr1008VwPi.vga', 54634.07),
(48, 'src/folders/resources/images/mobile/reformatted/vga/Algy17q7VM.vga', 14957.07),
(49, 'src/folders/resources/images/uploads/formed/jpeg/5E5ak3CkhU.jpeg', 8757.29),
(50, 'src/folders/resources/images/mobile/infigured/bmp/03z18luJc0.bmp', 33591.08);

INSERT INTO users (id, username, password, profile_picture_id)
VALUES
(1, 'UnderSinduxrein', '4l8nYGTKMW', 36),
(2, 'BlaAntigadsa', ':Q5wjT4[e', 49),
(3, 'ANinedsa', 'El[MwhxY)J', 8),
(4, 'ScoreImmagidefon', '`NGU>oS', 39),
(5, 'BlaSinduxrein', 'wJyfcwg*', 45),
(6, 'WhoDenoteBel', 'ajmISQi*', 38),
(7, 'WhatTerrorBel', 'R+-<+..Pl3j^', 2),
(8, 'AryaDenotehow', 'NNY5<e=', 11),
(9, 'UnveiledDenoteIana', 'no0*[ijt', 6),
(10, 'ScoreSinduxIana', '8xI:@-j2_.T', NULL),
(11, 'RoundAntigaBel', '4S>7EUNeUC@kv', 2),
(12, 'DarkImmagidsa', 'R.fh[f1Zh>2', 43),
(13, 'RoundInspecindi', 'AdKs>q]u7P`C', 20),
(14, 'AryaNinehow', 'X6j>`Huf2F(I', 14),
(15, 'ScoreAntigarein', 'UUD3H))<', 43),
(16, 'TheDivineBel', '-gCi:_Ub?ypT', 7),
(17, 'RoundArmydsa', 'SZ?F-:hW', 16),
(18, 'HighAsmahow', 'lyqF\vUG', 10),
(19, 'ZendArmyhow', 'DbW>9,', 2),
(20, 'BlaImmagiIana', 'upE;fg6+)n', 1),
(21, 'DeleteMe', 'asd', 2);

INSERT INTO posts (id, caption, user_id, picture_id)
VALUES
(1, '#everything #fuck #ring #faith #insta #infinity #swag #sunglasses #suzanita #smiley #justdoit #the #sleepless #ocean', 15, 31),
(2, '#cool #justdoit #sky #ocean #reason #feminist #gram #faith #hope #insta', 18, 8),
(3, '#suzanita #beautiful #swag #hope #sleepless #dusk #infinity #faith #women #fuck #gram #ocean #epic', 6, 49),
(4, '#insta #reason #sunglasses #swag #justdoit #what #dusk #morning #madness #feminist', 15, 14),
(5, '#sky #dawn #gerynikol #madness #women', 4, 3),
(6, '#infinity #women #smiley #my #epic #reason #yolo #beautiful #dawn #faith #happy #suzanita #morning #swag', 12, 31),
(7, '#cool #suzanita #the #dawn #my', 18, 27),
(8, '#epic #happy #insta #dusk #hope #sleepless #sky #swag #reason #justdoit #morning #smiley #yolo #sunglasses #ring #madness', 11, 32),
(9, '#justdoit #yolo #happy #insta #cool #madness #morning #faith #smiley #fuck #gerynikol #feminist', 20, 20),
(10, '#smiley #justdoit #feminist #fuck #everything #epic #dusk #gram #happy #women', 20, 6),
(11, '#infinity #sleepless #sky #yolo #fuck #ocean #gerynikol #women #morning #justdoit #the #what #dusk #reason #dawn #insta #happy', 17, 22),
(12, '#morning #sunglasses #reason #cool #suzanita #sleepless #everything #madness #gerynikol #swag #ring #women #happy #smiley #dawn #what #dusk #hope #the', 10, 3),
(13, '#sunglasses #infinity #madness #dusk #fuck #justdoit #the #gerynikol #suzanita #happy #beautiful #epic #what', 19, 40),
(14, '#madness #reason #feminist #cool #sunglasses #hope #gram #suzanita #justdoit #infinity #yolo #insta #faith #epic', 7, 38),
(15, '#morning #beautiful #infinity #insta #gram #hope #sleepless #ocean #suzanita #faith #dawn #sunglasses', 15, 2),
(16, '#dusk #insta #justdoit #suzanita #ocean #my #everything', 8, 41),
(17, '#women #ocean #ring #yolo #morning #insta #everything #sunglasses #what #cool #swag #infinity #suzanita #feminist #sleepless #hope #madness #dusk #epic', 4, 39),
(18, '#gram #hope #my #sky #insta #suzanita #gerynikol #infinity #ring #dawn #smiley #everything #madness #women #beautiful #sunglasses #morning #sleepless #cool', 18, 9),
(19, '#hope #reason #women #my #dawn #fuck #gram #swag #infinity #smiley #ocean #everything #faith #madness #sunglasses', 15, 41),
(20, '#everything #dawn #fuck #faith #what #sunglasses #happy', 19, 44),
(21, '#gerynikol #sunglasses #sky #what #dusk #smiley #insta #feminist #everything', 5, 46),
(22, '#morning #epic #hope #ring #gerynikol', 15, 18),
(23, '#everything #swag #faith #beautiful #dawn #sunglasses #dusk #infinity #suzanita #ring #what #sky #fuck #women', 17, 13),
(24, '#reason #my #morning #sky #the', 10, 22),
(25, '#yolo #madness #ocean #suzanita #feminist #fuck #cool #gerynikol #sunglasses #morning #sky #insta', 16, 23),
(26, '#dusk #smiley #cool #ocean #sunglasses #everything #faith #reason', 18, 2),
(27, '#sleepless #madness #reason #fuck #suzanita #everything #what', 16, 10),
(28, '#my #fuck #gerynikol #feminist #yolo #hope #dusk #sunglasses #suzanita #cool #gram #ring #sky #what #ocean #reason #dawn', 19, 16),
(29, '#justdoit #happy #ocean #ring #my #the #sunglasses #dusk #hope #morning #smiley #yolo', 7, 2),
(30, '#the #yolo #swag #sleepless #cool #everything #justdoit #my #fuck #sky #sunglasses', 10, 22),
(31, '#morning #infinity #happy #sleepless #justdoit #fuck', 15, 7),
(32, '#dawn #madness #reason #suzanita #gram #epic #beautiful #fuck #cool #faith #sky #ring #women #everything #gerynikol #morning #sleepless', 14, 33),
(33, '#madness #my #happy #gram #insta #women #what #swag', 1, 8),
(34, '#gerynikol #happy #sky #epic #everything #suzanita', 1, 7),
(35, '#morning #ocean #sky #dusk #justdoit #hope #epic #what #the #suzanita #madness #my #ring', 8, 1),
(36, '#feminist #happy #ring #my #swag #gerynikol #sleepless #yolo', 11, 45),
(37, '#sky #what #yolo #happy #swag #beautiful #dusk #gerynikol #ring #suzanita #feminist #women #morning #smiley #gram', 8, 37),
(38, '#the #happy #yolo #morning #reason #insta #smiley #suzanita #sky #feminist #what #dawn #fuck #my #faith', 8, 35),
(39, '#faith #gram #suzanita #what #everything #ocean #gerynikol #sky #my', 15, 17),
(40, '#ocean #epic #cool #reason #swag #sleepless #gerynikol #fuck #yolo #ring #infinity #justdoit #hope #dawn #my #morning #sunglasses', 10, 45);

INSERT INTO comments (id, content, user_id, post_id)
VALUES
(1, 'What the fuck? Aaarghhhh! Why?', 10, 40),
(2, 'Wow! Wow, epic!! How?', 11, 22),
(3, 'This is just... this is the best! Why?', 20, 37),
(4, 'The best! Simply amazing! Love you!', 16, 19),
(5, 'What is this? Aaarghhhh! Wtf!', 4, 2),
(6, 'Beautiful Aaarghhhh! Love you!', 6, 2),
(7, 'This is just... That body tho!!! Love you!', 6, 7),
(8, 'The best! Oh my god! Wtf!', 10, 12),
(9, 'I cannot beleive this How are you so beautiful? Love you!', 10, 39),
(10, 'The best! Absolutely majestic! Lol', 20, 28),
(11, 'What the fuck? Wow, epic!! Love you!', 1, 40),
(12, 'I cannot beleive this Absolutely majestic! How?', 9, 11),
(13, 'This is just... Wow, epic!! Wtf!', 10, 5),
(14, 'Super! Simply amazing! Lol', 17, 11),
(15, 'I cannot beleive this Them legs tho!!! Wtf!', 10, 38),
(16, 'Oh my god! Aaarghhhh! Love you!', 5, 19),
(17, 'I cannot beleive this this is the best! Love you!', 12, 34),
(18, 'Beautiful That body tho!!! Love you!', 7, 26),
(19, 'What the fuck? this is the best! Why?', 15, 22),
(20, 'This is just... Absolutely majestic! How?', 11, 32),
(21, 'Beautiful Absolutely majestic! How?', 4, 25),
(22, 'Oh my god! this is the best! Why?', 4, 22),
(23, 'Wow! Wow, epic!! Copying that!', 13, 40),
(24, 'The best! Them legs tho!!! Copying that!', 18, 14),
(25, 'What the fuck? Simply amazing! Best wishes!', 7, 14),
(26, 'The best! Oh my god! Copying that!', 1, 27),
(27, 'Oh my god! Wow, epic!! Love you!', 4, 15),
(28, 'This is just... Oh my god! Wtf!', 17, 37),
(29, 'This is just... Wow, epic!! Best wishes!', 16, 3),
(30, 'I cannot beleive this That body tho!!! Best wishes!', 15, 36),
(31, 'Wow! Simply amazing! Why?', 4, 25),
(32, 'Super! Oh my god! Wtf!', 17, 2),
(33, 'Oh my god! Aaarghhhh! Why?', 11, 20),
(34, 'What is this? Wow, epic!! Best wishes!', 5, 24),
(35, 'The best! Simply amazing! Wtf!', 19, 40),
(36, 'I cannot beleive this That body tho!!! Copying that!', 6, 35),
(37, 'Oh my god! Simply amazing! Lol', 3, 29),
(38, 'What is this? Simply amazing! How?', 12, 20),
(39, 'This is just... Aaarghhhh! How?', 17, 36),
(40, 'Beautiful Wow, epic!! How?', 7, 34),
(41, 'Beautiful How are you so beautiful? Love you!', 3, 12),
(42, 'What the fuck? How are you so beautiful? Why?', 5, 5),
(43, 'Wow! this is the best! Best wishes!', 1, 32),
(44, 'Super! Absolutely majestic! Copying that!', 18, 26),
(45, 'What is this? Wow, epic!! How?', 2, 18),
(46, 'Oh my god! Simply amazing! How?', 10, 34),
(47, 'The best! Oh my god! Why?', 13, 20),
(48, 'What the fuck? Aaarghhhh! Copying that!', 16, 36),
(49, 'Beautiful Wow, epic!! Why?', 20, 5),
(50, 'I cannot beleive this Simply amazing! Lol', 5, 36);

INSERT INTO users_followers (user_id, follower_id)
VALUES
(20, 10),
(5, 13),
(14, 12),
(5, 19),
(10, 13),
(4, 19),
(6, 12),
(14, 17),
(19, 9),
(20, 18),
(13, 10),
(2, 11),
(9, 13),
(20, 1),
(14, 5),
(1, 18),
(4, 10),
(18, 4),
(19, 18),
(20, 14),
(12, 2),
(5, 18),
(7, 10),
(18, 10),
(6, 17),
(2, 19),
(1, 6),
(1, 10),
(8, 14),
(5, 1),
(13, 5),
(4, 5),
(13, 6),
(16, 17),
(14, 10),
(18, 2),
(10, 6),
(7, 12),
(3, 17),
(5, 11),
(15, 10),
(16, 18),
(4, 3),
(18, 18),
(10, 8),
(17, 5),
(14, 19),
(2, 8),
(18, 3),
(13, 2),
(3, 2),
(16, 16),
(19, 1),
(10, 16),
(20, 10),
(8, 11),
(10, 14),
(7, 4),
(10, 6),
(2, 11),
(9, 18),
(7, 9),
(14, 14),
(9, 11),
(4, 20),
(14, 1),
(5, 4),
(8, 13),
(15, 20),
(20, 4),
(14, 3),
(19, 1),
(1, 6),
(15, 20),
(13, 19),
(19, 12),
(2, 3),
(13, 6),
(15, 10),
(2, 5),
(13, 19),
(12, 20),
(16, 8),
(7, 7),
(6, 14),
(9, 10),
(7, 19),
(18, 7),
(20, 7),
(6, 9),
(19, 9),
(19, 6),
(2, 2),
(20, 2),
(11, 3),
(19, 5),
(19, 15),
(11, 15),
(11, 19),
(5, 14);

SELECT 
    u.`id`, u.`username`
FROM
    users AS u
ORDER BY u.`id` ASC;

SELECT 
    u.`id`, u.`username`
FROM
    users AS u
        INNER JOIN
    users_followers uf ON uf.`user_id` = u.`id`
WHERE
    uf.`user_id` = uf.`follower_id`
ORDER BY u.`id` ASC;

SELECT 
    p.`id`, p.`path`, p.`size`
FROM
    pictures AS p
WHERE
    (p.`path` LIKE '%jpeg%'
        OR p.`path` LIKE '%png%')
        AND p.`size` > 50000
ORDER BY p.`size` DESC;
 
 SELECT 
    c.`id`,
    CONCAT(u.`username`, ' : ', c.`content`) AS 'full_comments'
FROM
    comments AS c
        JOIN
    users AS u ON c.`user_id` = u.`id`
ORDER BY c.`id` DESC;
 
 SELECT 
    u.`id`, u.`username`, CONCAT(p.`size`, 'KB') AS `size`
FROM
    users AS u
        INNER JOIN
    pictures AS p
        JOIN
    (SELECT 
        u.`id`, u.`username`, u.`profile_picture_id`
    FROM
        users AS u
    INNER JOIN pictures AS p ON u.`profile_picture_id` = p.`id`) AS nt
WHERE
    u.`id` != nt.`id`
        AND u.`profile_picture_id` = nt.`profile_picture_id`
ORDER BY u.`id` ASC;	
 
SELECT 
    p.`id`, p.`caption`, nt.`count`
FROM
    posts AS p
        INNER JOIN
    (SELECT 
        c.`post_id`, COUNT(`id`) AS `count`
    FROM
        comments AS c
    GROUP BY c.`post_id`) AS nt ON nt.`post_id` = p.`id`
ORDER BY nt.`count` DESC , p.`id` ASC
LIMIT 5;

SELECT 
    u.`id`, u.`username`, nt.`count`, nt2.`count`
FROM
    users AS u
        INNER JOIN
    (SELECT 
        user_id, COUNT(id) AS `count`
    FROM
        posts
    GROUP BY user_id) AS nt ON u.`id` = nt.`user_id`
        INNER JOIN
    (SELECT 
        user_id, COUNT(follower_id) AS `count`
    FROM
        users_followers
    GROUP BY user_id) AS nt2 ON u.`id` = nt2.`user_id`
ORDER BY nt2.`count` DESC
LIMIT 1;

SELECT 
    u.`id`, u.`username`, IFNULL(nt.`count`, 0)
FROM
    users AS u
        LEFT JOIN
    (SELECT 
        c.`user_id`, COUNT(c.`id`) AS `count`
    FROM
        comments AS c
    JOIN posts AS p ON c.`post_id` = p.`id`
    WHERE
        c.`user_id` = p.`user_id`
    GROUP BY c.`user_id`) AS nt ON u.`id` = nt.`user_id`
ORDER BY nt.`count` DESC , u.`id` ASC;

SELECT 
    u.`id`, u.`username`, nt.`caption`
FROM
    users AS u
        JOIN
    (SELECT 
        cq.`id`,
            cq.`user_id`,
            cq.`caption`,
            MAX(cq.`comments_count`)
    FROM
        (SELECT 
        p.`id`,
            p.`user_id`,
            p.`caption`,
            COUNT(c.`id`) AS `comments_count`
    FROM
        posts AS p
    LEFT JOIN comments AS c ON c.`post_id` = p.`id`
    GROUP BY p.`id`
    ORDER BY `comments_count` DESC , p.`id`) AS cq
    GROUP BY cq.`user_id`
    ORDER BY cq.`user_id`) AS nt ON u.`id` = nt.`user_id`;
    
SELECT p.`id`, p.`caption`,nt.`count`
FROM posts AS p 
JOIN (
	SELECT c.`post_id`, COUNT(c.`user_id`) AS `count`
	FROM comments AS c
	GROUP BY c.`post_id`
) AS nt
ON p.`id` = nt.`post_id`
ORDER BY nt.`count` DESC, p.`id`;