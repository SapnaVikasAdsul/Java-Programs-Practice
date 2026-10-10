-- Write a query to display all Engineering employees ordered by salary from highest to lowest?

select empname, salary from employees e where department="engineering" order by salary desc

-- Write a query to find the number of employees in each department?
select department, count(*) as total emp from employees group by department

SELECT department, COUNT(*) AS employee_count
FROM Employees
GROUP BY department;

-- Write a query to find the second-highest distinct salary?

SELECT MAX(salary) AS second_highest_salary
FROM Employees
WHERE salary < ( SELECT MAX(salary) FROM Employees );

-- Write a query to find employees earning more than the company average salary?

select salary from employees where salary >(select avg(salary) from employees)
SELECT employee_name, salary
FROM Employees
WHERE salary > (
  SELECT AVG(salary)
  FROM Employees
);

-- Write a query to find the highest salary in each department?
select department, max(salary) as max_salary from employees group by department

-- Write a query to find employees whose salary is higher than their manager's salary?
SELECT e.employee_name, e.salary, m.employee_name AS manager_name, m.salary AS manager_salary
FROM Employees AS e
JOIN Employees AS m ON e.manager_id = m.employee_id
WHERE e.salary > m.salary;

-- Write a query to display each order with the customer name?
SELECT o.order_id, c.customer_name, o.amount, o.status
FROM Orders AS o
JOIN Customers AS c ON o.customer_id = c.customer_id;

-- Find duplicate records based on email?
select email, count(*) from employee group by email having count(*)>1

-- Display employees with salary greater than their department avg
SELECT e.name, e.salary, e.department
FROM employee e
WHERE e.salary > (
    SELECT AVG(e2.salary)
    FROM employee e2
    WHERE e2.department = e.department
);


-- find the top 3 highest salaries?
select name, salary from employee where order by salary desc fetch first 3 rows only

-- find employees who have not worked on any project?
select name from employee e left join project p on e.employee_id=p.employee_id where p.employee_id is null

-- rank employees based on salary
select emp_id, name, salary, rank() over (order by salary desc) as salary_rank from employee 

-- find the number of employees in each department
select department_id , count(*) as total_emp from employee group by department_id

