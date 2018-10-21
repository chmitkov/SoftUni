CREATE TABLE planets (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE spaceports(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    planet_id INT,
    
    CONSTRAINT fk_spaceports_planets
    FOREIGN KEY(planet_id)
    REFERENCES planets(id)
);

CREATE TABLE spaceships(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(30) NOT NULL,
    light_speed_rate INT
);


ALTER TABLE spaceships 
MODIFY COLUMN light_speed_rate INT NOT NULL DEFAULT 0;

CREATE TABLE colonists(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    ucn CHAR(10) UNIQUE NOT NULL,
    birth_date DATETIME NOT NULL
);

CREATE TABLE journeys(
	id INT PRIMARY KEY AUTO_INCREMENT,
    journey_start DATETIME NOT NULL,
    journey_end DATETIME NOT NULL,
    purpose ENUM ('Medical','Technical','Educational','Military'),
    destination_spaceport_id INT,
    spaceship_id INT,
    
    CONSTRAINT fk_journeys_spaceports
    FOREIGN KEY(destination_spaceport_id)	
    REFERENCES spaceports(id),
    
    CONSTRAINT fk_journeys_spaceships
    FOREIGN KEY(spaceship_id)
    REFERENCES spaceships(id)
);

CREATE TABLE travel_cards(
	id INT PRIMARY KEY AUTO_INCREMENT,
	card_number CHAR(10) UNIQUE NOT NULL,
    job_during_journey ENUM('Pilot','Engineer','Trooper','Cleaner', 'Cook'),
    colonist_id INT,
    journey_id INT,
    
    CONSTRAINT fk_travel_cards_colonists
    FOREIGN KEY(colonist_id)
    REFERENCES colonists(id),
    
    CONSTRAINT fk_travel_cards_journeys
    FOREIGN KEY(journey_id)
    REFERENCES journeys(id)
);

#======================================================================

SELECT 
    t.`card_number`, t.`job_during_journey`
FROM
    travel_cards AS t
ORDER BY t.`card_number`;

#5============

SELECT 
    c.`id`, CONCAT(c.`first_name`, ' ', c.`last_name`), c.`ucn`
FROM
    colonists AS c
ORDER BY c.`first_name` , c.`last_name` , c.`id`;

#6====================

SELECT 
    j.`id`, j.`journey_start`, j.`journey_end`
FROM
    journeys AS j
WHERE
    j.`purpose` = 'Military'
ORDER BY j.`journey_start`;

#7========================

SELECT 
    c.`id`, CONCAT(c.`first_name`, ' ', c.`last_name`)
FROM
    colonists AS c
        JOIN
    travel_cards AS tc ON c.`id` = tc.`colonist_id`
WHERE
    tc.`job_during_journey` = 'Pilot'
ORDER BY c.`id`;

#8==================

SELECT 
    COUNT(c.`id`)
FROM
    colonists AS c
        JOIN
    travel_cards AS tc ON c.`id` = tc.`colonist_id`
        JOIN
    journeys AS j ON tc.`journey_id` = j.`id`
WHERE
    j.`purpose` = 'Technical';

#9 =========================

SELECT 
    ss.`name`, sport.`name`
FROM
    spaceships AS ss
        JOIN
    journeys AS j ON ss.`id` = j.`spaceship_id`
        JOIN
    spaceports AS sport ON j.`destination_spaceport_id` = sport.`id`
ORDER BY ss.`light_speed_rate` DESC
LIMIT 1;

#10================================

SELECT 
    s.`name`, s.`manufacturer`
FROM
    spaceships AS s
        JOIN
    journeys AS j ON s.`id` = j.`spaceship_id`
        JOIN
    travel_cards AS tr ON j.`id` = tr.`journey_id`
        JOIN
    colonists AS c ON c.`id` = tr.`colonist_id`
WHERE
    tr.`job_during_journey` = 'Pilot'
        AND YEAR(birth_date) > 1989
ORDER BY s.`name`;

#11 =========================

SELECT 
    p.`name`, sp.`name`
FROM
    journeys AS j
        JOIN
    spaceports AS sp ON j.`destination_spaceport_id` = sp.`id`
        JOIN
    planets AS p ON sp.`planet_id` = p.`id`
WHERE
    j.`purpose` = 'Educational'
ORDER BY sp.`name` DESC;

#12 ============================

SELECT 
    p.`name`, COUNT(j.`id`) AS `count`
FROM
    planets AS p
        JOIN
    spaceports AS sp ON sp.`planet_id` = p.`id`
        JOIN
    journeys AS j ON sp.`id` = j.`destination_spaceport_id`
GROUP BY p.`name`
ORDER BY `count` DESC , p.`name`;

#13 ============================

SELECT 
    j.`id`, p.`name`, sp.`name`, j.`purpose`
FROM
    planets AS p
        JOIN
    spaceports AS sp ON sp.`planet_id` = p.`id`
        JOIN
    journeys AS j ON sp.`id` = j.`destination_spaceport_id`
ORDER BY (j.`journey_end` - j.`journey_start`)
LIMIT 1;

#14=======================

SELECT 
    p.`name`, COUNT(c.`id`)
FROM
    planets AS p
        JOIN
    spaceports AS sp ON p.`id` = sp.`planet_id`
        JOIN
    journeys AS j ON sp.`id` = j.`destination_spaceport_id`
        JOIN
    travel_cards AS tr ON j.`id` = tr.`journey_id`
        JOIN
    colonists AS c ON c.`id` = tr.`colonist_id`
GROUP BY p.`name`
HAVING p.`name` = 'Otroyphus';


#==============================
SELECT 
    nt2.`job_during_journey`
FROM
    (SELECT 
        j.`id`
    FROM
        journeys AS j
    ORDER BY (j.`journey_end` - j.`journey_start`) DESC
    LIMIT 1) AS nt
        JOIN
    (SELECT 
        tc.`id`,
            tc.`journey_id`,
            tc.`job_during_journey`,
            COUNT(c.`id`) AS `count`
    FROM
        travel_cards AS `tc`
    JOIN colonists AS c ON tc.`colonist_id` = c.`id`
    GROUP BY tc.`job_during_journey`
    ORDER BY `count`) AS nt2 ON nt.`id` = nt2.`journey_id`;

#=========================================================

DELETE FROM colonists
WHERE colonists.id IN (SELECT c.`id`
FROM colonists AS c
LEFT JOIN travel_cards AS tc
ON tc.`colonist_id` = c.`id`
WHERE tc.`colonist_id` IS NULL;

#15===========================================================================

DELIMITER $$
CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE result INT;
	SET result := (
    SELECT  COUNT(c.`id`) 
	FROM planets AS p	
	JOIN spaceports AS sp
	ON p.`id` = sp.`planet_id`
	JOIN journeys AS j
	ON sp.`id` = j.`destination_spaceport_id`
	JOIN travel_cards AS tr
	ON j.`id` = tr.`journey_id`
	JOIN colonists AS c
	ON c.`id` = tr.`colonist_id`
	GROUP BY p.`name`
	HAVING p.`name` = planet_name
    );
	RETURN result;
END $$
DELIMITER ;
SELECT UDF_COUNT_COLONISTS_BY_DESTINATION_PLANET('Otroyphus');

#16======================================

DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate
(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11)) 
BEGIN

  START TRANSACTION;
	IF(SELECT count(id) FROM spaceships WHERE name = spaceship_name ) =0
	THEN SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
	ROLLBACK;
	ELSE
		UPDATE spaceships
		SET spaceships.light_speed_rate = spaceships.light_speed_rate+ light_speed_rate_increse
		WHERE spaceships.name = spaceship_name;
    END IF;
END$$

CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'Na Pesho koraba'

CALL udp_modify_spaceship_light_speed_rate ('USS Templar', 5);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'USS Templar'


