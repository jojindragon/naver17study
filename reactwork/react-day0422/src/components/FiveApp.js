import React from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import food from '../image2/11.jpg';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
  variants: [
    {
      props: ({ expand }) => !expand,
      style: {
        transform: 'rotate(0deg)',
      },
    },
    {
      props: ({ expand }) => !!expand,
      style: {
        transform: 'rotate(180deg)',
      },
    },
  ],
}));

const FiveApp = () => {
  const [expanded, setExpanded] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <div>
      <h3 className='alert alert-success'>FiveApp - MUI Card</h3>
      <Card sx={{ maxWidth: 345 }}>
        <CardHeader
          avatar={
            <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
              Jo
            </Avatar>
          }
          action={
            <IconButton aria-label="settings">
              <MoreVertIcon />
            </IconButton>
          }
          title="먹음직스러운 망고빙수!"
          subheader="2025-04-22"
        />
        <CardMedia
          component="img"
          height="194"
          image={food}
          alt="Paella dish"
        />
        <CardContent>
          <Typography variant="body2" sx={{ color: 'gray' }}>
            망고빙수는 하야트 호텔의 시그니쳐 빙수입니다(가격 15만원)
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites" style={{color: red[500]}}>
            <FavoriteIcon />
          </IconButton>
          <IconButton aria-label="share">
            <ShareIcon />
          </IconButton>
          <ExpandMore
            expand={expanded}
            onClick={handleExpandClick}
            aria-expanded={expanded}
            aria-label="show more"
          >
            <ExpandMoreIcon />
          </ExpandMore>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <CardContent>
            <Typography sx={{ marginBottom: 2 }}>Method:</Typography>
            <Typography sx={{ marginBottom: 2 }}>
              Heat 1/2 cup of the broth in a pot until simmering, add saffron and set
              aside for 10 minutes.
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
	            Card Test #1
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
              MUI Component Card Test #1
            </Typography>
            <Typography>
              Testing~
            </Typography>
          </CardContent>
        </Collapse>
      </Card>
    </div>
  );
};

export default FiveApp;