import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { backgroundImages, user, feed } from './reducers'
import initialData from './initialState'
import { composeWithDevTools } from 'redux-devtools-extension';


const store = createStore(
    combineReducers({ backgroundImages, user, feed }),
    initialData,composeWithDevTools(
    applyMiddleware(thunk))
)

export default store
