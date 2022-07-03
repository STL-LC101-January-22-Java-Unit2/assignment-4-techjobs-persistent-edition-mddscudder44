-- Part 1: Test it with SQL
--, list the columns and their data types in the table as a SQL comment.
SELECT * FROM job;

-- Part 2: Test it with SQL
SELECT name FROM employer WHERE location = "St. Louis City";


-- Part 3: Test it with SQL4

DROP TABLE job;

-- Part 4: Test it with SQL

SELECT *
FROM skill
LEFT JOIN job_skills
ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;