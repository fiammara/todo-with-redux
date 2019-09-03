import React from 'react';
import PropTypes from 'prop-types';
import DeleteIcon from '@material-ui/icons/Delete';

const TodoItem = (props) => {
  const { name, id, onDelete } = props;
  return (
    <tr>
      <td>{name}</td>
      <td>
        <button type="button" onClick={() => onDelete(id)}>
          Archive
          <DeleteIcon color="action" />
        </button>
      </td>
    </tr>
  );
};

TodoItem.propTypes = {
  name: PropTypes.string.isRequired,
  id: PropTypes.number.isRequired,
  onDelete: PropTypes.func.isRequired
};

export default TodoItem;
