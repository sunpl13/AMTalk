package altong.mon.amtalk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Vector;

import altong.mon.amtalk.databinding.ItemHeaderBinding;
import altong.mon.amtalk.databinding.ItemProfileBinding;
import altong.mon.amtalk.item.Profile;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class ProfileAdapter extends RecyclerView.Adapter {

    private static final int MY_HEADER = 0;

    private static final int MY_PROFILE = 1;

    private static final int FRIEND_HEADER = 2;

    private Vector<Profile> profiles;

    private Context context;

    public ProfileAdapter(Vector<Profile> profiles, Context context) {
        this.profiles = profiles;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;

        if( viewType == MY_HEADER || viewType == FRIEND_HEADER ) {
            ItemHeaderBinding headerBinding = ItemHeaderBinding.inflate(LayoutInflater.from(context), parent, false);
            holder = new HeaderHolder(headerBinding);
        } else {
            ItemProfileBinding profileBinding = ItemProfileBinding.inflate(LayoutInflater.from(context), parent, false);
            holder = new ProfileHolder(profileBinding);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position == MY_HEADER && holder instanceof HeaderHolder) {
            HeaderHolder itemViewHolder = (HeaderHolder) holder;
            final ItemHeaderBinding binding = itemViewHolder.binding;
            binding.friendHeaderTv.setText(profiles.get(position).getNickname());
        } else if (position == FRIEND_HEADER && holder instanceof HeaderHolder) {
            HeaderHolder itemViewHolder = (HeaderHolder) holder;
            final ItemHeaderBinding binding = itemViewHolder.binding;
            binding.friendHeaderTv.setText(profiles.get(position).getNickname());
        } else if (position == MY_PROFILE && holder instanceof ProfileHolder) {
            ProfileHolder itemViewHolder = (ProfileHolder) holder;
            final ItemProfileBinding binding = itemViewHolder.binding;
            binding.userNameTv.setText(profiles.get(position).getNickname());
            binding.profileMsgTv.setText(profiles.get(position).getMsg());
            //binding.profileImgView.setImageResource(profiles.get(position).getUrl());
            //Picasso.with(context).load(profiles.get(position).getStrUrl()).transform(new RoundedCornersTransformation(50,0)).resize(100,100).into(binding.profileImgView);
        } else {
            ProfileHolder itemViewHolder = (ProfileHolder) holder;
            final ItemProfileBinding binding = itemViewHolder.binding;
            binding.userNameTv.setText(profiles.get(position).getNickname());
            binding.profileMsgTv.setText(profiles.get(position).getMsg());
            binding.profileImgView.setImageResource(profiles.get(position).getUrl());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return MY_HEADER;
        } else if (position == 2) {
            return FRIEND_HEADER;
        } else {
            return position;
        }
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }


    private class HeaderHolder extends RecyclerView.ViewHolder {

        ItemHeaderBinding binding;

        HeaderHolder(ItemHeaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private class ProfileHolder extends RecyclerView.ViewHolder {

        ItemProfileBinding binding;

        ProfileHolder(ItemProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
