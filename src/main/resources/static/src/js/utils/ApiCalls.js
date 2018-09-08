class ApiCalls {
    static getAll(url) {
        var myHeaders = new Headers()
        if (localStorage.getItem('accessToken')) myHeaders.append('Authorization', `Bearer ${localStorage.getItem('accessToken')}`)
        return fetch(url, {
            headers: myHeaders
        })
    }

    static postAll(url, json, customHeader) {
        var myHeaders = new Headers({"Content-Type": "application/json"})
        if (localStorage.getItem('accessToken')) myHeaders.append('Authorization', `Bearer ${localStorage.getItem('accessToken')}`)
        if (customHeader) myHeaders.append("Connection-Type", customHeader)
        return fetch(url, {
            method: 'post',
            headers: myHeaders,
            body: json
        })
    }
}

export default ApiCalls