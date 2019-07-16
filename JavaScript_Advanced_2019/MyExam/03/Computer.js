class Computer {
    constructor(ramMemory, cpuGHz, hddMemory) {
        this.ramMemory = ramMemory;
        this.cpuGHz = cpuGHz;
        this.hddMemory = hddMemory;
        this.taskManager = [];
        this.installedPrograms = [];
    }

    installAProgram(name, requiredSpace) {
        if (this.hddMemory < requiredSpace) {
            throw Error('There is not enough space on the hard drive');
        }

        this.hddMemory -= requiredSpace;
        let program = {name, requiredSpace};
        this.installedPrograms.push(program);

        return program;
    }

    uninstallAProgram(name) {
        let program = this.installedPrograms.find(x => x.name === name);

        if (program === undefined) {
            throw Error('Control panel is not responding');
        }

        this.hddMemory += program.requiredSpace;
        this.installedPrograms =
            this.installedPrograms.filter(x => x.name !== name);

        return this.installedPrograms;
    }

    openAProgram(name) {
        let program = this.installedPrograms.find(x => x.name === name);

        if (program === undefined) {
            throw Error(`The ${name} is not recognized`);
        }

        if (this.taskManager.find(x => x.name === name) !== undefined) {
            throw Error(`The ${name} is already open`);
        }

        let ram = (program.requiredSpace / this.ramMemory) * 1.5;
        let cpu = ((program.requiredSpace / this.cpuGHz) / 500) * 1.5;

        if (this.getAllFreeRam() + ram >= 100) {
            throw Error(`${name} caused out of memory exception`);
        }

        if (this.getAllFreeCpu() + cpu >= 100) {
            throw Error(`${name} caused out of cpu exception`);
        }

        let obj = {name, ramUsage: ram, cpuUsage: cpu};

        this.taskManager.push(obj);

        return obj;
    }

    taskManagerView() {
        if (this.taskManager.length === 0) {
            return 'All running smooth so far';
        }

        let resultString = '';
        this.taskManager.forEach(x => {
            resultString += `Name - ${x.name} | Usage - CPU: ${x.cpuUsage.toFixed(0)}%, RAM: ${x.ramUsage.toFixed(0)}%\n`
        });

        return resultString.trim();
    }

    get availableSpace() {
        return this.hddMemory;
    }

    getAllFreeRam() {
        return this.taskManager.reduce((a, b) => a.ramUsage + b.ramUsage, 0);
    }

    getAllFreeCpu() {
        return this.taskManager.reduce((a, b) => a.cpuUsage + b.cpuUsage, 0);
    }
}


let computer = new Computer(4096, 7.5, 250000);

computer.installAProgram('Word', 7300);
computer.installAProgram('Excel', 10240);
computer.installAProgram('PowerPoint', 12288);
computer.installAProgram('Solitare', 1500);

computer.openAProgram('Word');
computer.openAProgram('Excel');
computer.openAProgram('PowerPoint');
computer.openAProgram('Solitare');

console.log(computer.taskManagerView());



