import React from 'react';
import Modal from 'react-modal';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import TodoItem from '../components/TodoItem';
import ItemAddComponent from '../ItemAddComponent';
import { deletePost, openModal, closeModal } from '../actions/index';

function TodoList({
 todos, onDelete, modalIsOpen, closeM, openM 
}) {
  if (!todos) {
    return <div>No Data</div>;
  }
  return (
    <div>
      <Modal
        modalClassName="addModal"
        isOpen={modalIsOpen}
        onRequestClose={closeM}
      >
        <ItemAddComponent className="itemAdd" onCancel={closeM} />
      </Modal>
      <p>To do list</p>
      <table className="table">
        <tbody>
          {todos.map((post) => (
            <TodoItem
              name={post.name}
              id={post.id}
              key={post.id}
              onDelete={onDelete}
            />
          ))}
        </tbody>
      </table>
      <br />
      <button type="button" onClick={openM} className="addButton">
        Add new
      </button>
    </div>
  );
}

TodoList.propTypes = {
  todos: PropTypes.instanceOf(Array).isRequired,
  onDelete: PropTypes.func.isRequired,
  openM: PropTypes.func.isRequired,
  closeM: PropTypes.func.isRequired,
  modalIsOpen: PropTypes.bool.isRequired
};

const mapStateToProps = (state) => ({
  todos: state.todos,
  modalIsOpen: state.modal.modalIsOpen
});

const mapDispatchToProps = (dispatch) => ({
  onDelete: (id) => {
    dispatch(deletePost(id));
  },
  openM: () => {
    dispatch(openModal());
  },
  closeM: () => {
    dispatch(closeModal());
  }
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TodoList);

/* const mapDispatchToProps = dispatch => {
  return {
    onDelete: id => {
      dispatch(deletePost(id));
    }
  };
}; */

/* const mapDispatchToProps = {
  openM: openModal,
  closeM: closeModal,
  
}; */
