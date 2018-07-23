import React from 'react'
import styles from './login.sass'
import {domain, auth0Cred} from '../../config.js'

const webAuth = new auth0.WebAuth({domain: auth0Cred.domain, clientID: auth0Cred.clientID})

const socialOAuth2 = (webAuth, serviceProvider) => {
    webAuth.popup.authorize({
        connection: serviceProvider,
        display:'popup',
        audience:'https://localhost',
        responseType: 'code',
        scope: 'openid email offline_access',
        access_type: 'offline',
        prompt:'consent',
        redirectUri: 'https://localhost/social-login-redirect.html'
        },
        (err, authResult) => console.log(err))}



const receiveToken = (event) => {
    //if (event.origin !== domain) return

    console.log(event.data)

    var code = getParameterByName('code', JSON.parse(event.data).url )

    console.log(code);

   /* webAuth.parseHash({ hash: JSON.parse(event.data).url },
                        (err, authResult) => {
                            if (err) return console.log(err)

                            console.log(authResult)

                            //localStorage.setItem('accessToken', authResult.accessToken);

                            })*/


                            }

window.addEventListener("message", receiveToken, false)



function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}

/*




Get access token


https://kineticexpress.auth0.com/authorize?response_type=code&client_id=7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O&connection=facebook&redirect_uri=https://localhost/social-login-redirect.html&access_type=offline


https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token&client_id=2010760015905060&client_secret=4d22ef1cf7ef8886484d77953dea5fd8&fb_exchange_token=EAAckxox6ASQBAOjKVZA3oJ3cO5w52nzaHdVNbn5KcVrcFmNVIE6O9qAb5gRb3eqqRoWFz5dDjIuUv4xUl4Q2FxcxPyddFTenIsDP1xaPevY4UDWsoZBggLiXYXQ0TtnZCZCTeyyZCFkXo6cVhUrzPd0ZBwx2rUZC4jZChHBg6A5kS9PN61QZC6yJZB3yihnFwVpNoZD

https://kineticexpress.auth0.com/authorize?response_type=code&client_id=7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O&connection=google-oauth2&redirect_uri=https://localhost/social-login-redirect.html&access_type=offline

https://kineticexpress.auth0.com/authorize?response_type=code&client_id=7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O&connection=google-oauth2&redirect_uri=https://localhost/social-login-redirect.html&access_type=offline&prompt=consent


https://kineticexpress.auth0.com/authorize?response_type=code&client_id=7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O&connection=facebook&redirect_uri=https://localhost/social-login-redirect.html&access_type=offline&prompt=consent


curl --request POST \
  --url 'https://kineticexpress.auth0.com/oauth/token' \
  --header 'content-type: application/json' \
  --data '{"grant_type":"authorization_code","client_id": "7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O","client_secret": "A9_2PNqixCjxJ7hlGIJn8licpeiOX0-UTRiHcV7LNuCq3dPtHhYN9-_yQJ670Afc","code": "m6jQOdAHimwN36A0","redirect_uri": "https://localhost/social-login-redirect.html"}'




https://kineticexpress.auth0.com/authorize?response_type=token&client_id=7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O&connection=google-oauth2&redirect_uri=https://localhost/social-login-redirect.html&access_type=offline&prompt=consent

Make class out of login, move event handler in mount remove in unmount

If token, send to authenticate with GET,

Authenticate with Post is different and provides with a basic answer

Change token response_type to code as to refresh later on

*/


const Login = ({googleLogin = () => socialOAuth2(webAuth, 'google-oauth2'),
               facebookLogin = () => socialOAuth2(webAuth, 'facebook')}) =>
    <form className={styles.login}>
        <input type="text" name="email" value="email" />
        <input type="text" name="password" value="password" />
        <button type="button">forgot your password?</button>
        <div>
            <input type="submit" value="log in" />
            <p>or</p>
            <button onClick={googleLogin} type="button">login in with Google</button>
            <button onClick={facebookLogin}  type="button">login in with Facebook</button>
        </div>
        <button type="button">create account</button>
    </form>


export default Login
