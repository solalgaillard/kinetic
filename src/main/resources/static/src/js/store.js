import { createStore, combineReducers } from 'redux'
import { backgroundImages } from './reducers'
import initialData from './initialState'

const store = createStore(
    combineReducers({ backgroundImages }),
    initialData
)

export default store
