import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux'
import store from './redux/store'
import Qinetic from './components/Qinetic.jsx'


render(
    <Provider store={store}>
        <Qinetic />
    </Provider>,
    document.getElementsByTagName('body')[0]
)
