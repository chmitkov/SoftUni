class Organization {
    constructor(name, budget) {
        this.name = name;
        //this.totalBudget = budget;
        this.employees = [];
        this.departmentsBudget = budget;
    }

    set departmentsBudget(budget) {
        this.budget = {
            marketing: budget * 0.4,
            finance: budget * 0.25,
            production: budget * 0.35,
        };
        return this.budget;
    }

    add(employeeName, department, salary) {
        if (this.budget[department] < salary) {
            return `The salary that ${department} department can offer to you Mr./Mrs. ${employeeName} is ${this.budget[department]}.`
        }

        this.employees.push({employeeName, department, salary});
        this.budget[department] -= salary;

        return `Welcome to the ${department} team Mr./Mrs. ${employeeName}.`

    }

    employeeExists(employeeName) {
        let employee = this.employees.find(x => x.employeeName === employeeName);

        if (employee === undefined) {
            `Mr./Mrs. ${employeeName} is not working in ${this.name}.`
        } else {
            return `Mr./Mrs. ${employee.employeeName} is part of the ${employee.department} department.`;
        }
    }

    leaveOrganization(employeeName) {
        let employee = this.employees.find(x => x.employeeName === employeeName);

        if (employee === undefined) {
            return `Mr./Mrs. ${employeeName} is not working in ${this.name}.`;
        } else {
            this.budget[employee.department] += employee.salary;
            return  `It was pleasure for ${this.name} to work with Mr./Mrs. ${employeeName}.`;
        }
    }

    status(){
        let resultString = `${this.name.toUpperCase()} DEPARTMENTS:`;
        for (const dep in this.budget) {
            resultString += `\n${dep} `;
            resultString += `| Employees: ${this.employees.filter(x=>x.department === dep).length}: `;
            resultString += `${this.employees.filter(x=>x.department === dep).map(x=>x.employeeName).join(', ')} | `;
            resultString += `Remaining Budget: ${this.budget[dep]}`;
        }

        return resultString;
    }
}
let organization = new Organization('SBTech', 1000);


console.log(organization.add('Peter', 'marketing', 12));
console.log(organization.add('Robert', 'production', 20));

console.log(organization.add('Peter', 'marketing', 8));
console.log(organization.add('Robert', 'production', 20));
console.log(organization.add('Peter', 'production', 20));

console.log(organization.status());
