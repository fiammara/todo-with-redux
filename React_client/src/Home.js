import React from 'react';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import { activateGeod, closeGeod } from './actions/index';

function Home({ geod, activate, close }) {
  return (
    <div>
      <h1>{geod.title || 'Hello World!'}</h1>

      {geod.title ? (
        <button 
          type="button" 
          onClick={close}
        >
          Exit Geod
        </button>
      ) : (
        <button
          type="button"
          onClick={() => activate({ title: 'I am redux!' })}
        >
          Click Me!
        </button>
      )}
    </div>
  );
}

Home.propTypes = {
  close: PropTypes.func.isRequired,
  activate: PropTypes.func.isRequired,
  geod: PropTypes.shape({
    title: PropTypes.string  
  }) 
};

Home.defaultProps = {
  geod: PropTypes.shape({
    title: ''  
  }) 
};

const mapStateToProps = (state) => ({
  geod: state.geod
});

const mapDispatchToProps = {
  activate: activateGeod,
  close: closeGeod
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Home);
