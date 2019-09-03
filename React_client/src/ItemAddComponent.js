import React, { Component } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';
import PropTypes from 'prop-types';

class ItemAddComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {     
          name: ''       
    };
  }

   handleChangeFor = (property) => (event) => {
        this.setState({ [property]: event.target.value });
    };

    addItem = (event) => {
      const { name } = this.state;
        event.preventDefault();

        const newItem = {
            name
        };

        if (name !== undefined) {
            axios
                .post('http://localhost:8080/api/todos/addTodo', newItem)
                .then(window.location.replace('/todos'));
        } else {
            alert("new item can't be empty");
        }
    };

  render() {
    const { onCancel } = this.props;
    return (
      <div>
        <p>Name your todo</p>

        <div>
          <form>
            <div className="form-group">
              <input
                type="text"
                autoComplete="off"
                value={this.name}
                onChange={this.handleChangeFor('name')}
              />
            </div>

            <div className="btn-group">
              <button
                className="inputButton"
                type="button"
                onClick={onCancel}
                
              >
                Cancel
              </button>
              <button 
                className="inputButton"
                type="button"
                onClick={this.addItem}
               
              >
                <NavLink to={{ pathname: '/todos' }} />
                OK
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}

ItemAddComponent.propTypes = {
  onCancel: PropTypes.func.isRequired
};

export default ItemAddComponent;
