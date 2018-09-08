import styles from './main.sass'
import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux'
import store from './reduxStore/createStore'
import {Qinetic} from './components/Qinetic.jsx'


render(
<Provider store={store}>
    <Qinetic />
    </Provider>,
document.getElementById('qinetic')
)
