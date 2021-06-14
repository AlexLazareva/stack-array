$(document).ready(() => {
    $.ajax({
        url: 'peek-process',
        method: 'GET',
        success: (response) => {
            let processName = response.name;
            let processId = response.processId;
            let threads = response.threadLinkedList;

            $('#processName').text(processName);
            $('#processId').text(processId);
            if (threads.length > 0) {
                createTable(threads);
            }
        }
    });
});

function createTable(items) {
    for (let i = 0; i < items.length; i++) {
        let row = "<tr>"+
            '<th scope="row">' +
            getThreadId(items[i]) +
            "</th>" +
            "<td>" +
            getThreadName(items[i]) +
            "</td>" +
            "<td>" +
            getThreadsState(items[i]) +
            "</td>" +
            "<td>" +
            '<button class="btn btn-danger" onclick="deleteThread(' + items[i].id +
            ')">-</button>' +
            "</td>" +
            "</tr>";
        $('#table-body').append(row);
    }
}

function getThreadId(item) {
    return item == null ? "нет id" : item.id;
}

function getThreadName(item) {
    return item == null ? "без имени" : "Поток " + item.id;
}

function getThreadsState(item) {
    return item == null ? "Новый" : item.state;
}

function deleteThread(id) {
    $.ajax({
        url: '/processes_and_threads_algoritms_Web_exploded/remove-thread',
        method: 'POST',
        data: {
            threadIndex: id
        },
        success: () => {
            window.location.reload();
        }
    });
}