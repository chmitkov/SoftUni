#01. Employee Address 
SELECT 
    e.`employee_id`,
    e.`job_title`,
    e.`address_id`,
    a.`address_text`
FROM
    employees AS e
        INNER JOIN
    addresses AS a ON e.`address_id` = a.`address_id`
ORDER BY `address_id`
LIMIT 5;

#02. Addresses with Towns 
SELECT 
    e.`first_name`, e.`last_name`, nt.`town`, nt.`address_text`
FROM
    employees AS e
        INNER JOIN
    (SELECT 
        a.`address_text`, a.`address_id`, t.`name` AS 'town'
    FROM
        addresses AS a
    INNER JOIN towns AS t ON a.`town_id` = t.`town_id`) AS nt ON e.`address_id` = nt.`address_id`
ORDER BY `first_name` , `last_name`
LIMIT 5;

#03. Sales Employee 
SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`last_name`,
    d.`name` AS `department_name`
FROM
    employees AS e
        INNER JOIN
    departments AS d ON e.`department_id` = d.`department_id`
WHERE
    d.`name` = 'Sales'
ORDER BY `employee_id` DESC;

#04. Employee Departments 
SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`salary`,
    d.`name` AS `department_name`
FROM
    employees AS e
        INNER JOIN
    departments AS d ON e.`department_id` = d.`department_id`
WHERE
    e.`salary` > 15000
ORDER BY e.`department_id` DESC
LIMIT 5;

#05. Employees Without Project 
SELECT 
    e.`employee_id`, e.`first_name`
FROM
    employees AS e
        LEFT JOIN
    (SELECT 
        ep.`employee_id`, p.`project_id`
    FROM
        employees_projects AS ep
    LEFT JOIN projects AS p ON ep.`project_id` = p.`project_id`) AS `nt` ON e.`employee_id` = nt.`employee_id`
WHERE
    nt.`project_id` IS NULL
ORDER BY `employee_id` DESC
LIMIT 3;

#06. Employees Hired After 
SELECT 
    e.`first_name`,
    e.`last_name`,
    e.`hire_date`,
    d.`name` AS `dept_name`
FROM
    employees AS e
        INNER JOIN
    departments AS d ON e.`department_id` = d.`department_id`
WHERE
    e.`hire_date` > '1/1/1999'
        AND d.`name` IN ('Sales' , 'Finance')
ORDER BY e.`hire_date`;

#07. Employees with Project 
SELECT 
    e.`employee_id`, e.`first_name`, p.`name` AS `project_name`
FROM
    employees AS e
        INNER JOIN
    employees_projects AS ep ON e.`employee_id` = ep.`employee_id`
        INNER JOIN
    projects AS p ON ep.`project_id` = p.`project_id`
WHERE
    p.`start_date` > '2002-08-13'
        AND p.`end_date` IS NULL
ORDER BY e.`first_name` , p.`name`
LIMIT 5;

#08. Employee 24 
SELECT 
    e.`employee_id`,
    e.`first_name`,
    (CASE
        WHEN nt.`start_date` > '2004-12-31' THEN NULL
        ELSE nt.`name`
    END) AS `project_name`
FROM
    employees AS e
        INNER JOIN
    (SELECT 
        ep.`employee_id`, p.`name`, p.`start_date`
    FROM
        employees_projects AS ep
    INNER JOIN projects AS p ON ep.`project_id` = p.`project_id`) AS nt ON e.`employee_id` = nt.`employee_id`
WHERE
    e.`employee_id` = 24
ORDER BY nt.`name`; 

#09. Employee Manager 
SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`manager_id`,
    e2.`first_name`
FROM
    employees AS e
        JOIN
    employees AS e2 ON e.`manager_id` = e2.`employee_id`
WHERE
    e.`manager_id` IN (3 , 7)
ORDER BY e.`first_name` ASC;

#10. Employee Summary 
SELECT 
    e.`employee_id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS `employee_name`,
    CONCAT(em.`first_name`, ' ', em.`last_name`) AS `manager_name`,
    d.`name`
FROM
    employees AS e
        INNER JOIN
    departments AS d ON e.`department_id` = d.`department_id`
        INNER JOIN
    employees AS em ON e.`manager_id` = em.`employee_id`
ORDER BY e.`employee_id`
LIMIT 5;

#11. Min Average Salary 
SELECT 
    MIN(nt.`min`)
FROM
    (SELECT 
        AVG(`salary`) AS `min`
    FROM
        employees AS e
    GROUP BY e.`department_id`) AS nt;
	
#12. Highest Peaks in Bulgaria 
SELECT 
    c.`country_code`,
    m.`mountain_range`,
    p.`peak_name`,
    p.`elevation`
FROM
    countries AS c
        JOIN
    mountains_countries AS mc ON c.`country_code` = mc.`country_code`
        JOIN
    mountains AS m ON mc.`mountain_id` = m.`id`
        JOIN
    peaks AS p ON p.`mountain_id` = m.`id`
WHERE
    c.`country_name` = 'Bulgaria'
        AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

#13. Count Mountain Ranges 
SELECT 
    c.`country_code`,
    COUNT(mc.`mountain_id`) AS `mountain_range`
FROM
    countries AS c
        JOIN
    mountains_countries AS mc ON c.`country_code` = mc.`country_code`
GROUP BY c.`country_code`
HAVING c.`country_code` IN ('US' , 'RU', 'BG')
ORDER BY `mountain_range` DESC;

#14. Countries with Rivers 
SELECT 
    c.`country_name`, r.`river_name`
FROM
    countries AS c
        JOIN
    continents AS con ON c.`continent_code` = con.`continent_code`
        LEFT JOIN
    countries_rivers AS cr ON c.`country_code` = cr.`country_code`
        LEFT JOIN
    rivers AS r ON cr.`river_id` = r.`id`
WHERE
    con.`continent_name` = 'Africa'
ORDER BY c.`country_name`
LIMIT 5;

#16. Countries without any Mountains
SELECT 
    COUNT(c.`country_code`) AS country_count
FROM
    countries AS c
        LEFT JOIN
    mountains_countries AS mc ON c.`country_code` = mc.`country_code`
WHERE
    mc.`country_code` IS NULL;

