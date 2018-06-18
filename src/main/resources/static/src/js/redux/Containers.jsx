import {connect} from "react-redux";
import { BackgroundSlideshow } from '../Components/backgroundSlideshow/BackgroundSlideshow.jsx';

export const ChangeImage = connect (
    state =>
        ({
            img: state.backgroundImages
        }),
    null
)(BackgroundSlideshow)