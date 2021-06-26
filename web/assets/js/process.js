$(document).ready(() => {
    $.ajax({
        url: 'peek-process',
        method: 'GET',
        success: (response) => {
            let processName = response.name;
            let processId = response.processId;
            let threads = response.threadList;
            console.log(threads);

            $('#processName').text(processName);
            $('#processId').text(processId);
            if (threads) {
                createTable(threads);
            }
        }
    });
});

function createTable(items) {
    let head = items.head.next;
    let tmp = head;
    let i = 0;

    while (tmp) {
        let row = "<tr>"+
            '<th scope="row">' +
            getThreadId(tmp.val) +
            "</th>" +
            "<td>" +
            getThreadName(tmp.val) +
            "</td>" +
            "<td>" +
            getThreadsState(tmp.val) +
            "</td>" +
            "<td>" +
            '<button class="btn btn-danger" onclick="deleteThread(' + i +
            ')">-</button>' +
            "</td>" +
            "</tr>";
        $('#table-body').append(row);
        tmp = tmp.next;
        i++;
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