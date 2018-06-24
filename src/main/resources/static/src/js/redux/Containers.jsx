import { connect } from "react-redux"
import { BackgroundSlideshow } from '../Components/backgroundSlideshow/BackgroundSlideshow.jsx'
import { Feed } from '../Components/Home/Home.jsx'
import {loadFeed} from './actions.js'


export const ChangeImage = connect (
    state =>
        ({
            img: state.backgroundImages
        }),
    null
)(BackgroundSlideshow)




export const Home = connect (
    state =>
        ({
            homeFeed: state.homeFeed
        }),
    dispatch => ({
        stuff() {
            dispatch(loadFeed())
        }
        })
)(Feed)