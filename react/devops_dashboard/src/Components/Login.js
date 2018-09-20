import React, { Component } from "react";
import "../css/Login.css";
import img from "../images/devops.png"
import ApplicationManager from "../Managers/ApplicationManager/ApplicationManager"


class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: ""
        };
    }

    validateForm() {
        console.log('validating');
        return this.state.email.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
        console.log(`handeling change for : ${event.target.id + event.target.value}`)
        this.setState({
            [event.target.id]: event.target.value
        });
    };

    handleSubmit = event => {
        if(this.validateForm()){
            console.log('we are in event');
            this.props.callback(true,{name: this.state.email, jobTitle: 'Developer'});
        }
    };

    render() {
        return (
            <div className="limiter">
                <div className="container-login100">
                    <div className="wrap-login100">
                        <div className="login100-pic js-tilt" data-tilt>
                            <img src={img} alt="IMG"/>
                        </div>
                        <form className="login100-form">
                            <span className="login100-form-title">
                                Member Login
                            </span>
                            <div className="wrap-input100"
                                 data-validate="Valid email is required: ex@abc.xyz">
                                <input className="input100" type="text" id="email" name="email" placeholder="Email" onChange={this.handleChange.bind(this)}/>
                                    <span className="focus-input100"></span>
                                    <span className="symbol-input100">
                                        <i className="fa fa-envelope" aria-hidden="true"></i>
                                    </span>
                            </div>
                            <div className="wrap-input100" data-validate="Password is required">
                                <input className="input100" type="password" id='password' name="pass" placeholder="Password" onChange={this.handleChange.bind(this)}/>
                                    <span className="focus-input100"></span>
                                    <span className="symbol-input100">
                                        <i className="fa fa-lock" aria-hidden="true"></i>
                                    </span>
                            </div>

                            <div className="container-login100-form-btn" >
                                <button className="login100-form-btn" type='button' onClick={this.handleSubmit}>
                                    Login
                                </button>
                            </div>

                                {/*<div className="text-center p-t-12">*/}
                            {/*<span className="txt1">*/}
                                {/*Forgot*/}
                            {/*</span>*/}
                                    {/*<a className="txt2" href="#">*/}
                                        {/*Username / Password?*/}
                                    {/*</a>*/}
                                {/*</div>*/}

                                {/*<div className="text-center p-t-136">*/}
                                    {/*<a className="txt2" href="#">*/}
                                        {/*Create your Account*/}
                                        {/*<i className="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>*/}
                                    {/*</a>*/}
                                {/*</div>*/}
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;