function solve(arr) {
    let inventory = arr.shift().split(' ');

    for (let row of arr) {
        let commands = row.split(' ');
        let item = commands[1];
        switch (commands[0]) {
            case 'Buy':
                if (!inventory.includes(item)) {
                    inventory.push(item);
                }
                break;
            case 'Trash':
                if (inventory.includes(item)) {
                    inventory.splice(inventory.indexOf(item), 1);
                }
                break;
            case 'Repair':
                if (inventory.includes(item)) {
                    inventory.splice(inventory.indexOf(item), 1);
                    inventory.push(item);
                }
                break;
            case 'Upgrade':
                let searchedItem = item.split('-')[0];
                if (inventory.includes(searchedItem)) {
                    inventory
                        .splice(inventory.indexOf(searchedItem)
                            + 1, 0, item.replace('-',':'));
                }
                break;
        }
    }

    console.log(inventory.join(' '))
}

solve(["SWORD Shield Spear",
    "Buy Bag",
    "Trash Shield",
    "Repair Spear",
    "Upgrade SWORD-Steel",
    "Fight!"]);