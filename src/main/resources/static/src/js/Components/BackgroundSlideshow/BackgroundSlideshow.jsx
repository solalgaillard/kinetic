import React, { PropTypes, Component } from 'react'
import { Transition } from 'react-transition-group';
import { connect } from 'react-redux'
import cx from 'classnames';
import styles from './background-slideshow.sass'


class BackgroundSlideshow extends Component {

    constructor(props) {
        super(props)
        this.state = { count: 0, prev: 0, next: 0 }
    }

    componentWillMount() {
        const { img } = this.props
        this.setState({next: Math.floor(Math.random()*img.length)})
        setInterval(() => {
            this.setState(state => ({
                count: state.count + 1,
                prev: state.next,
                next: Math.floor(Math.random()*img.length)
            }))
        },20000)
    }

    /*<div className={styles['black-overlay']}></div>
    <div className={styles.gradient}></div>
<Transition
in={true}
timeout= { 0 }
>
{ state => {
    switch (state) {

        case 'entered':
            return <style> {`\
                                            .back::after{\
                                            opacity: 0;\
                                            animation: fade-in 10s forwards;\
                                            animation-iteration-count: infinite;\
                                            background-image: url(${img[next].url});\
                                            }\
                                        `}</style>


        default:
            return null



    }
}
}


</Transition>*/



    render() {
        const { img } = this.props
        const { count, prev, next } = this.state
        console.log(img[prev].url)
        console.log(count)

        return (
            <aside key={count} className={cx(styles['background-slideshow'] , 'back')}>
                {count > 0 && <style> {`\
                                            .back::before{\
                                            background: url(${img[prev].url}) no-repeat center center fixed;\
                                            }\
                                        `}</style>
                }
                <style> {`\
                                            .back::after{\
                                            animation: fade-in 10s forwards;\
                                            background: url(${img[next].url}) no-repeat center center fixed;\
                                            }\
                                        `}</style>



            </aside>
        )

    }


}



const ChangeImage = connect (
    state =>
        ({
            img: state.backgroundImages
        }),
    null
)(BackgroundSlideshow)


export default ChangeImage