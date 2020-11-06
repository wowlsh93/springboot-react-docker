import React, {Component} from "react";
import Input from './Input';
import { sendMessage } from '../net/LoginCall';

class Sample extends Component {

    constructor(props) {
        super(props);

        this.state = {
            user: this.props.currentUser,
            isauth: this.props.isAuthenticated
        }

        
        this.onSendMessage = this.onSendMessage.bind(this);

    }

    componentWillMount() {


    }


    onSendMessage (msgText) {
        sendMessage(this.state.user, msgText).
        then(res => {
            console.log('Sent', res);
        }).catch(err => {
            console.log('Error Occured while sending message to api');
        })
    }

    componentDidMount() {


    }

    render() {

        return (
            <div className="App">
                Sample
                <Input onSendMessage={this.onSendMessage} />
            </div>
        );
    }
}

export default Sample;