import auth0 from 'auth0-js';


var webAuth = new auth0.WebAuth({
    domain:       'kineticexpress.auth0.com',
    clientID:     '7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O'
});

// Trigger login with google
webAuth.authorize({
    connection: 'google-oauth2'
});

var url = webAuth.client.buildAuthorizeUrl({
    clientID: '7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O', // string
    responseType: 'token', // code or token
    redirectUri: 'http://localhost/greeting',
    state: 'YOUR_STATE'
});

// Redirect to url
// ...