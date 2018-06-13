
import React, { Component } from 'react';
//To include the path of the Dog API
const Rand ='/images/random';
const Data = 'https://dog.ceo/api/breed/';

class App extends Component {
 constructor(props) {
 super(props);
 //To display the first dog in the page
 this.state = {value: 'pug',dogimg:'false'};

 this.handleChange = this.handleChange.bind(this);}

 handleChange(event) 
 {this.setState({ value: event.target.value });}

  //Function to Pull the API data in the application
  ImgGen(){
	  //To fetch the API and exact path of the Dog image required
    fetch(Data+this.state.value+Rand)
	.then((result) => {
      return result.json();
    }).then((jsonResult) => {
	this.setState({ dogimg: jsonResult.message })
      console.log(jsonResult);
    })
  }

  //To render the Data on the page based on the requirement
 render() {
 return (
 <div>
 <h1>{this.state.value} Dog Image Generator</h1>
  <p> Select the button to change the dogs picture</p>
 <select value={this.state.value} onChange={this.handleChange}>
 <option value="pug">pug</option>
 <option value="vizsla">vizsla</option>
 <option value="eskimo">eskimo</option>
 </select>

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button onClick={() => this.ImgGen()}>Fetch</button>
 <div>{this.ImgGen()}</div>
 <div>
 <img src = {this.state.dogimg}/>
 </div>
 </div>

 );
 }
}

export default App;