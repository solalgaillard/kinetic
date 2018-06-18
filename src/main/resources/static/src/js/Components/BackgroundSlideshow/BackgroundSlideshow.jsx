import React, { PropTypes, Component } from 'react'
import cx from 'classnames';
import styles from './background-slideshow.sass'


export class BackgroundSlideshow extends Component {

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
        },200000)
    }




    render() {
        const { img } = this.props
        const { count, prev, next } = this.state
        console.log(img[prev].url)
        console.log(count)

        return (
            <aside>
            <div key={count} className={cx(styles['background-slideshow'] , 'back')}>
                {count > 0 && <style> {`\
                                            .back::before{\
                                            background-image: url(${img[prev].url});\
                                            }\
                                        `}</style>
                }
                <style> {`\
                                            .back::after{\
                                            animation: fade-in 10s forwards;\
                                            background-image: url(${img[next].url});\
                                            }\
                                        `}</style>



            </div>
            <div className={styles.gradient}></div>
            </aside>
)

}
/* CSS from gradient::before and gradient will dynamically be changed after image analysis but it is static as is, the values will be passed */

}