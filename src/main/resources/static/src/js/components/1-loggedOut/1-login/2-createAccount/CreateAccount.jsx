import React, { PropTypes, Component } from 'react'
import { Redirect } from 'react-router'
import styles from './create-account.sass'
import ApiCalls from '../../../../utils/ApiCalls'

import { connect } from "react-redux"




class CreateAccountPre extends Component {

    constructor(props) {
        super(props)
    }

    submit = e => {
        console.log('called')
        const {backToLogin} = this.props
        const{_firstName, _lastName, _email, _password, _dob, _tel}=this.refs
        console.log(_firstName)
        e.preventDefault()
        ApiCalls.postAll('https://localhost/sign-up', JSON.stringify({
            firstName: _firstName.value,
            lastName: _lastName.value,
            email: _email.value,
            password:_password.value,
            DOB: _dob.value,
            phoneNumber: _tel.value
            }
        )).then(response => {
                if (response.ok) {
                    console.log('acc created')
                    backToLogin('createAccount')
                }
            })
          .catch(error => {
                console.log(error)
          })
    }

    render()  {

        return (
            <form className={styles['create-account']} onSubmit={this.submit} >
                <input type="text" name="first-name" ref="_firstName" placeholder="First name" />
                <input type="text" name="last-name" ref="_lastName" placeholder="Last name" />
                <input type="email" name="email" ref="_email" placeholder="Email" />
                <input type="email" name="email-confirm" ref="_emailConfirm" placeholder="Confirm Email" />
                <input type="password" name="password" ref="_password" placeholder="Password" />
                <input type="password" name="password-confirm" ref="_passwordConfirm" placeholder="Confirm Password" />
                <input type="date" name="date-of-birth" ref="_dob" placeholder="Date of Birth" />
                <input type="tel" name="tel" ref="_tel" placeholder="Phone" />
                <p>At kinetic, we respect your data and will not expose it to third party actors.<br />
                    You own it and at any point can trash it out of our servers. Learn more about our <a href="">economical model</a>.<br />
                    By clicking on Create Account, you agree to our <a href="">terms</a>.</p>
                <input type="submit" value="create account" />
            </form>
        )

    }


}


export const CreateAccount = connect (
    null,
    dispatch => ({
        saveUser(json, customHeader) {
            dispatch(loadUser(json, customHeader))
        }
    })
)(CreateAccountPre)
















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
  --data '{"grant_type":"authorization_code","client_id": "7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O","client_secret": "A9_2PNqixCjxJ7hlGIJn8licpeiOX0-UTRiHcV7LNuCq3dPtHhYN9-_yQJ670Afc","code": "ToP_ekNKJ01kU99C","redirect_uri": "https://localhost/social-login-redirect.html"}'




https://kineticexpress.auth0.com/authorize?response_type=token&client_id=7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O&connection=google-oauth2&redirect_uri=https://localhost/social-login-redirect.html&access_type=offline&prompt=consent

Make class out of login, move event handler in mount remove in unmount

If token, send to authenticate with GET,

Authenticate with Post is different and provides with a basic answer

Change token response_type to code as to refresh later on

*/



