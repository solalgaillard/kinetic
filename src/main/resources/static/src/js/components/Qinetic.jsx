import React, { Component } from 'react'
import {HashRouter, Route } from 'react-router-dom'
import { Switch, Redirect } from 'react-router'
import { render } from 'react-dom';
import { connect } from "react-redux"
import {BackgroundSlideShowContainer} from './common/backgroundSlideshow/BackgroundSlideshow.jsx'
import {Login} from './1-loggedOut/1-login/Login.jsx'
import Home from './2-loggedIn/1-home/Home.jsx'
import styles from './qinetic.sass'
import cx from "classnames";


const QineticPre = ({user}) =>
    <main className={styles.Qinetic}>
        <BackgroundSlideShowContainer />
        <HashRouter>
        {user ?
            <Switch>
                <Route exact path="/home" component={Home} />
                <Route render={() => (<Redirect to="/home"/>)}/>
            </Switch>
                    :
            <Switch>
                <Route exact path="/" component={Login}/>
                <Route render={() => (<Redirect to="/"/>)}/>
            </Switch>
        }
        </HashRouter>
    </main>





export const Qinetic = connect (
    state =>
        ({
            user: state.user
        })
)(QineticPre)










/*

class App extends Component {


    componentWillMount() {
        localStorage.getItem('accessToken')
        this.setState({token: Math.floor(Math.random()*img.length)})

    }

    render() {
        const {token} = this.state

        return (
            <main className={styles.Qinetic}>
                <BackgroundSlideShowContainer />
                <Login />
                {token !== null &&
                <HashRouter>
                    <div>
                        <Route path="/home" component={Home} />

                    </div>
                </HashRouter>}
            </main>
        )

    }

}*/
/*

subscribe to user, if props user exist
* <Route exact path="/" component={Home} />
*
* */
