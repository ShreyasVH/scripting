const axios = require('axios');

const get = async (url, additionalHeaders = {}) => {
    let defaultHeaders = {
        'X-Requested-With': 'XMLHttpRequest'
    };
    let headers = Object.assign({}, defaultHeaders, additionalHeaders);

    return execute({
        method: 'get',
        url,
        headers
    });
};

const post = (url, payload, additionalHeaders = {}) => {
    let defaultHeaders = {
        'X-Requested-With': 'XMLHttpRequest',
        'Content-Type': 'application/json'
    };
    let headers = Object.assign({}, defaultHeaders, additionalHeaders);

    let data = (('application/json' === headers["Content-Type"]) ? JSON.stringify(payload) : payload);

    return execute({
        method: 'post',
        data,
        url,
        headers
    });
};

const put = (url, payload, additionalHeaders = {}) => {
    let defaultHeaders = {
        'X-Requested-With': 'XMLHttpRequest',
        'Content-Type': 'application/json'
    };
    let headers = Object.assign({}, defaultHeaders, additionalHeaders);

    let data = (('application/json' === headers["Content-Type"]) ? JSON.stringify(payload) : payload);

    return execute({
        method: 'put',
        data,
        url,
        headers
    });
};

const del = (url, additionalHeaders = {}) => {
    let defaultHeaders = {
        'X-Requested-With': 'XMLHttpRequest'
    };
    let headers = Object.assign({}, defaultHeaders, additionalHeaders);

    return execute({
        method: 'delete',
        url,
        headers
    });
};

const execute = options => (axios(options));

(async () => {
    let url = 'http://cors.playframework.com/api?input=abc';
    let headers = {
        'c': 'C',
        'd': 'D'
    };
    let response = await get(url, headers);
    console.log(JSON.stringify(response.data, null, ' '));

    console.log('---------------------------------------------------------------');

    url = 'http://cors.playframework.com/api';
    let payload = {
        'a': 'A',
        'b': 'B'
    };
    headers = {
        'c': 'C',
        'd': 'D'
    };
    response = await post(url, payload, headers);
    console.log(JSON.stringify(response.data, null, ' '));

    console.log('---------------------------------------------------------------');

    url = 'http://cors.playframework.com/api?input=abc';
    headers = {
        'c': 'C',
        'd': 'D'
    };
    response = await del(url, headers);
    console.log(JSON.stringify(response.data, null, ' '));

    console.log('---------------------------------------------------------------');

    url = 'http://cors.playframework.com/api';
    payload = {
        'a': 'A',
        'b': 'B'
    };
    headers = {
        'c': 'C',
        'd': 'D'
    };
    response = await put(url, payload, headers);
    console.log(JSON.stringify(response.data, null, ' '));
})();