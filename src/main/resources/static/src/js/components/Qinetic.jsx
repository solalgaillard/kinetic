import React from 'react'
import {HashRouter, Route } from 'react-router-dom'
import Login from './login/Login.jsx'
import { ChangeImage, Home } from './containers.jsx'
import styles from './qinetic.sass'



const App = () =>
    <main className={styles.Qinetic}>
        <ChangeImage />
        <HashRouter>
            <div>
                <Route exact path="/" component={Login} />
                <Route path="/home" component={Home} />

            </div>
        </HashRouter>
    </main>

export default App
