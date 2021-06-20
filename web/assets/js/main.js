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
            createTable(processes);
            if (processes[processes.length - 1] !== null) {
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
    return item == null ? "-" : item.processId;
}

function getProcessName(item) {
    return item == null ? "пустая ячейка массива" : item.name;
}

function getThreadsAmount(item) {
    return item == null ? "0" : item.threadLinkedList.length;
}

