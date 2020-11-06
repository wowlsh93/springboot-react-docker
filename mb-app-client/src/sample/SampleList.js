
import React, { Component } from 'react';
import Sample from './Sample';


class SampleList extends Component {

    render() {
        let samplelist;
        if(this.props.isAuthenticated) {
            samplelist = (<div>
                <h2>SampleList</h2>
                <Sample isAuthenticated={this.props.isAuthenticated}
                        currentUser={this.props.currentUser}></Sample>
            </div>);
        }
        else {
            samplelist = (<div>intro</div>)
        }

        return (
            samplelist
        );
    }
}







export default SampleList;