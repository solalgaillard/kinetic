import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { backgroundImages, user, homeFeed } from './reducers'
import initialData from './initialState'

const store = createStore(
    combineReducers({ backgroundImages, user, homeFeed }),
    initialData,
    applyMiddleware(thunk)
)

export default store
