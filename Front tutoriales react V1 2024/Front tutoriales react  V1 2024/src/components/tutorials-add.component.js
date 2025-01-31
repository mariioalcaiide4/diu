import TutorialDataService from "../services/tutorial.service";
import React, { Component } from "react";


export default class TutorialsAdd extends Component {
    constructor(props){
        super(props);

        this.state = {
            id: "", //lista de tutoriales
            title: "", //tutorial seleccionado de la lista
            description: "",
            published: false
          };

        this.onChangeTitle = this.onChangeTitle.bind(this);
        this.onChangeDescription = this.onChangeDescription.bind(this);
        this.onChangeCheckBox = this.onChangeCheckBox.bind(this);
        this.saveTutorial = this.saveTutorial.bind(this);

        }

        onChangeTitle(event){
            this.setState({
                title: event.target.value
            });
        }

        onChangeDescription(event){
            this.setState({
                description: event.target.value
            });
        }

        onChangeCheckBox(event){
            this.setState({
                published: event.target.value
            });
        }

        saveTutorial(){
            var data = {
                title: this.state.title,
                description: this.state.description,
                published: this.state.published
            };

            TutorialDataService.create(data)
        }

        render(){
            return(
                <div>
                    <div>
                        <label htmlFor="title">Titulo</label>
                        <input type="text" id="title" required value={this.state.title} onChange={this.onChangeTitle} name="title"/>
                    </div>
                    <div>
                        <label htmlFor="description">Descripcion</label>
                        <input type="text" id="description" required value={this.state.description} onChange={this.onChangeDescription} name="description"/>
                    </div>
                    <div>
                        <label htmlFor="published">Publicado</label>
                        <input type="checkbox" id="published" required value={this.state.published} onChange={this.onChangeCheckBox} name="published"/>
                    </div>
                    <button onClick={this.saveTutorial}>Guardar</button>
                </div>
            );
        }




    }
