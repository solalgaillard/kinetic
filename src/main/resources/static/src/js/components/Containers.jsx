import { connect } from "react-redux"
import { BackgroundSlideshow } from './backgroundSlideshow/BackgroundSlideshow.jsx'
import { Feed } from './feed/Feed.jsx'
import {loadFeed} from '../redux/actions.js'


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