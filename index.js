import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, World</Text>
      </View>
    );
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor: '#f9c2ff',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
    color: 'red'
  }
});

AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => HelloWorld
);