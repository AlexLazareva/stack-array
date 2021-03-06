$(document).ready(() => {
    getSubsystemManagerFields();
});

function getSubsystemManagerFields() {
    $.ajax({
        url: 'subsystem-list',
        method: 'GET',
        success: (response) => {
            let systemType = response.systemType;
            let processes = response.processes.stackArray.reverse();

            $('#systemType').text(systemType);
            console.log(processes);
            createTable(processes);
            if (processes[processes.length - 1] !== null) {
                $('#empty-message').addClass('hide');
                $('.buttons-wrapper').removeClass('hide');
            }
            $('#loader').removeClass('show');
        }
    });
}

function createTable(items) {
    for (let i = 0; i < items.length; i++) {
        let row = "<tr>"+
            '<th scope="row">' +
            getProcessId(items[i]) +
            "</th>" +
            "<td>" +
            getProcessName(items[i]) +
            "</td>" +
            "<td>" +
            getThreadsAmount(items[i]) +
            "</td>" +
            "</tr>";
        $('#table-body').append(row);
    }
}

function getProcessId(item) {
    return item === null ? "-" : item.processId;
}

function getProcessName(item) {
    return item === null ? "пустая ячейка массива" : item.name;
}

function getThreadsAmount(item) {
    if (item === null) {
        return "0";
    } else {
        if (item.threadList && item.threadList.size) {
            return item.threadList.size;
        }
        return "0";
    }
}

