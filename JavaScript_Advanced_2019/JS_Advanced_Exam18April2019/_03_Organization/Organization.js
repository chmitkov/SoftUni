class Organization {
    constructor(name, budget,) {
        this.name = name;
        this.budget = budget;
        this.employees = [];
        this.marketing = budget;
        this.finance = budget;
        this.production = budget;
    }

    set marketing(budget) {
        this._marketing = budget * 0.4;
    }

    get marketing() {
        return this._marketing;
    }

    set finance(budget) {
        this._finance = budget * 0.35;
    }

    get finance() {
        return this._finance;
    }

    set production(budget) {
        this._production = budget * 0.35;
    }

    get production() {
        return this._production;
    }

    add(employeeName, department, salary) {
        if (this['_' + department] < +salary) {
            return `The salary that ${department} department can offer to you Mr./Mrs. ${employeeName} is ${this[department]}.`;
        }

        let employeeObj = {employeeName, department, salary};

        this['_' + department] -= +salary;

        this._employees.push(employeeObj);

        return `Welcome to the ${department} team Mr./Mrs. ${employeeName}.`;

    }

    employeeExists(employeeName) {
        let employee = this._employees
            .find(e => e.employeeName === employeeName);

        if (employee === undefined) {
            return `Mr./Mrs. ${employeeName} is not working in ${this.name}.`
        } else {
            return `Mr./Mrs. ${employeeName} is part of the ${employee.department} department.`
        }
    }

    leaveOrganization(employeeName) {

        let employee = this._employees
            .find(e => e.employeeName === employeeName);

        if (employee === undefined) {
            return `Mr./Mrs. ${employeeName} is not working in ${this.name}.`
        }

        this['_' + employee.department] += employee.salary;

        this._employees.filter(e => e.employeeName !== employee.employeeName);

        return `It was pleasure for ${this.name} to work with Mr./Mrs. ${employeeName}.`;
    }

    status() {
        let resultString = `${this.name.toUpperCase()} DEPARTMENTS:`;

        resultString += `\nMarketing | Employees: ${this._employees.filter(e => e.department === 'marketing').length}: ${this._employees.filter(e => e.department === 'marketing').map(e => e = e.employeeName).join(', ')} |  Remaining Budget: ${this._marketing}`;
        resultString += `\nFinance | Employees: ${this._employees.filter(e => e.department === 'finance').length}: ${this._employees.filter(e => e.department === 'finance').join(', ')} |  Remaining Budget: ${this._finance}`;
        resultString += `\nProduction | Employees: ${this._employees.filter(e => e.department === 'production').length}: ${this._employees.filter(e => e.department === 'production').join(', ')} |  Remaining Budget: ${this._production}`;

        return resultString;
    }
}

let organization = new Organization('SBTech', 1000);

console.log(organization.add('Peter', 'marketing', 800));
console.log(organization.add('Robert', 'production', 2000));
console.log(organization.add('Peter', 'production', 2000));
