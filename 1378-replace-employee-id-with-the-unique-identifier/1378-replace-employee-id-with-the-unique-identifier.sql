# Write your MySQL query statement below


-- select Employees.name, EmployeeUNI.unique_id from Employees
-- left join EmployeeUNI
-- on Employees.id=EmployeeUNI.id

select e.name, eu.unique_id
from Employees e
left join EmployeeUNI eu
on e.id=eu.id