import React from 'react';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import ArchiveItem from '../components/ArchiveItem';

function ArchiveList({ data }) {
  if (!data) {
    return <div>No Data</div>;
  }
  return (
    <div>
      <p>Archive list</p>
      <table className="table">
        <tbody>
          {data.map((post) => (
            <ArchiveItem name={post.name} id={post.id} key={post.id} />
      ))}
        </tbody>
      </table>
    </div>
  );
}

ArchiveList.propTypes = {
  data: PropTypes.instanceOf(Array).isRequired
};

const mapStateToProps = (state) => ({
  data: state.data
});

export default connect(
  mapStateToProps,
  null
)(ArchiveList);

//  https://stackoverflow.com/questions/38728884/how-to-properly-make-rest-calls-from-reactjs-redux-application
//  https://appdividend.com/2018/10/03/redux-thunk-tutorial-example/
//  https://appdividend.com/2018/06/15/react-redux-axios-tutorial-example/
//  https://tighten.co/blog/react-101-using-redux

/* componentDidMount() {
  const { dispatch, getleftpaneProductCatalogue }

  dispatch(getleftpaneProductCatalogue())   
} */
