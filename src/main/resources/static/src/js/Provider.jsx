import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux'
import store from './redux/store'
import App from './Components/App.jsx'


render(
    <Provider store={store}>
        <App />
    </Provider>,
    document.getElementsByTagName('body')[0]
)
